import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static String readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Constants.FILE_PATH));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    private static void writeToFile(String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.FILE_PATH, true));
        writer.write(data);
        writer.close();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments given");
            return;
        }

        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                String[] employees = line.split(",");
                for (String employee : employees) {
                    System.out.println(employee);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                System.out.println(line);
                String[] employees = line.split(",");
                Random rand = new Random();
                int index = rand.nextInt(employees.length);
                System.out.println(employees[index]);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                String newEmployee = args[0].substring(1);
                writeToFile(", " + newEmployee);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                String[] employees = line.split(",");
                boolean found = false;
                String searchEmployee = args[0].substring(1);
                for (String employee : employees) {
                    if (employee.equals(searchEmployee)) {
                        System.out.println("Employee found!");
                        found = true;
                        break;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                char[] characters = line.toCharArray();
                boolean inWord = false;
                int wordCount = 0;
                for (char c : characters) {
                    if (c == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(wordCount + " word(s) found " + characters.length);
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                String[] employees = line.split(",");
                String employeeToUpdate = args[0].substring(1);
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i].equals(employeeToUpdate)) {
                        employees[i] = "Updated";
                    }
                }
                writeToFile(String.join(",", employees));
            } catch (Exception e) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                String line = readFromFile();
                String[] employees = line.split(",");
                String employeeToDelete = args[0].substring(1);
                List<String> employeeList = new ArrayList<>(Arrays.asList(employees));
                employeeList.remove(employeeToDelete);
                writeToFile(String.join(",", employeeList));
            } catch (Exception e) {
            }
            System.out.println("Data Deleted.");
        }
    }
}