import java.io.*;
import java.util.*;

public class EmployeeManager {

    // Read data from the file
    private static String readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_PATH))) {
            return reader.readLine();
        }
    }

    // Write data to the file
    private static void writeToFile(String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_PATH, true))) {
            writer.write(data);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments given");
            return;
        }

        String command = args[0];
        if (command.equals("l")) {
            // Load data
        } else if (command.equals("s")) {
            // Select random employee
        } else if (command.startsWith("+")) {
            // Add new employee
        } else if (command.startsWith("?")) {
            // Search for employee
        } else if (command.equals("c")) {
            // Count words
        } else if (command.startsWith("u")) {
            // Update employee
        } else if (command.startsWith("d")) {
            // Delete employee
        } else {
            System.out.println("Invalid argument: " + command);
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readFromFile().split(",");
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                System.out.println(line);
                String[] employees = line.split(",");
                int index = new Random().nextInt(employees.length);
                System.out.println(employees[index]);
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newEmployee = args[0].substring(1);
                writeToFile(", " + newEmployee);
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readFromFile().split(",");
                String searchEmployee = args[0].substring(1);
                boolean found = false;
                for (String employee : employees) {
                    if (employee.equals(searchEmployee)) {
                        System.out.println("Employee found!");
                        found = true;
                        break;
                    }
                }
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                String[] words = line.split(" ");
                int wordCount = words.length;
                System.out.println(wordCount + " word(s) found " + line.length());
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readFromFile().split(",");
                String employeeToUpdate = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(employeeToUpdate)) {
                        employees[i] = "Updated";
                    }
                }
                writeToFile(String.join(",", employees));
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String[] employees = readFromFile().split(",");
                String employeeToDelete = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeToDelete);
                writeToFile(String.join(",", employeeList));
            } catch (Exception e) {
                // Handle exception
            }
            System.out.println("Data Deleted.");
        }
    }
}