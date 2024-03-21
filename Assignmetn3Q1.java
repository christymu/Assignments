import java.util.Scanner;

public class Assignment3Q1 {
    private static final int maxemployees = 10;
    private static String[] employees = new String[maxemployees];
    private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        while (true) {    
            Scanner userinput = new Scanner(System.in);
            System.out.println("1. Add a new employee full name to the database.");
            System.out.println("2. Display the list of all employees.");
            System.out.println("3. Search for an employee by lastname or firstname.");
            System.out.println("4. Remove an employee from the database.");
            System.out.println("5. Exit the program.");
            System.out.println("enter number 1-5 to indicate your action");
            int option = userinput.nextInt();
            userinput.close();

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");

            }
        }
    }
            

    private static void addEmployee() {
        System.out.print("Enter the full name of the new employee (Lastname, Firstname): ");
        String fullName = scanner.nextLine();

        // Check if array is full
        if (countEmployees() >= maxemployees) {
            System.out.println("Database is full. Cannot add more employees.");
            return;
        }
        // Check for duplicate names
        for (String employee : employees) {
            if (employee != null && employee.equals(fullName)) {
                System.out.println("Employee with the same name already exists. Cannot add duplicate names.");
                return;
            }
        }

        // Find the first available slot and add the employee
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = fullName;
                System.out.println("Employee added successfully.");
                return;
            }
        }
    }

    private static void displayEmployees() {
        System.out.println("List of all employees:");
        for (String employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private static void searchEmployee() {
        System.out.print("Enter the firstname or lastname of the employee to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (String employee : employees) {
            if (employee != null && (employee.contains(name))) {
                System.out.println("Employee found: " + employee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Employee not found in the database.");
        }
    }

    private static void removeEmployee() {
        System.out.print("Enter the lastname of the employee to remove: ");
        String lastName = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].split(", ")[0].equals(lastName)) {
                System.out.println("Employee found: " + employees[i]);
                System.out.print("Do you want to remove this employee? (yes/no): ");
                String confirm = scanner.nextLine().toLowerCase();
                if (confirm.equals("yes")) {
                    employees[i] = null;
                    found = true;
                    System.out.println("Employee removed successfully.");
                } else {
                    System.out.println("Removal canceled.");
                }
            }
        }

        if (!found) {
            System.out.println("Employee not found in the database.");
        }
    }

    private static int countEmployees() {
        int count = 0;
        for (String employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
        
    }


 }
