import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class InClass_Lab_6_Mario_Granados {

    public static class Name {
        private String firstName;
        private String lastName;

        Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;

        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Name name = (Name) obj;
            return firstName.equalsIgnoreCase(name.firstName) && lastName.equalsIgnoreCase(name.lastName);
        }

        @Override
        public int hashCode() {
            return firstName.hashCode() + lastName.hashCode();
        }

        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static class TelephoneDirectory {

        private Map<Name, String> phoneBook;

        public TelephoneDirectory() {
            phoneBook = new HashMap<>();
        }

        public void readFile(Scanner data) {
            // System.out.println("From readFile()\n");
            while (data.hasNextLine()) {
                String lineText = data.nextLine().trim();
                String[] parts = lineText.split("\\s+"); 

                String firstName = parts[0];
                String lastName = parts[1];
                if(lastName.contains(",")) {
                    lastName = lastName.replace(",", ""); // fix the comma implementation
                }
                String phoneNumber = parts[2];

                Name name = new Name(firstName.toLowerCase(), lastName.toLowerCase()); // my approach to the search fix, convert everything to lowercase
                phoneBook.put(name, phoneNumber);
            }

        }

        public void writeFile(PrintWriter output) {
            for (Map.Entry<Name, String> entry : phoneBook.entrySet()) {
                Name name = entry.getKey();
                String number = entry.getValue();

                output.println(name.getFirstName().substring(0,1).toUpperCase() + " " + name.getLastName().substring(0,1).toUpperCase() + ", " + number); //Uppercase the first Letter
            }
        }

        public String getPhoneNumber(Name personName) {
            //TODO Fix the ","
            Name temp = personName;
            temp.firstName = temp.firstName.toLowerCase();
            temp.lastName = temp.lastName.toLowerCase();
            return phoneBook.get(temp);
        }

        public String getPhoneBook() {
            String book = "";
            for(HashMap.Entry<Name, String> entry : phoneBook.entrySet()) {
                book += entry.getKey() + " : " + entry.getValue() + "\n";
            }
            return book;
        }

        public void addPhoneNumber(Name personName, String phoneNumber) {
            this.phoneBook.put(personName, phoneNumber);
            System.out.println("You're changes will only save when you hit close!");
        }

        public void removePhoneNumber(Name personName) {
            this.phoneBook.remove(personName);
            System.out.println("You're changes will only save when you hit close!");
        }


    }

    public class Main {
        private static final Name INPUT_ERROR = new Name("error", "error");

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            TelephoneDirectory directory = new TelephoneDirectory();
            String fileName = "data.txt";
            int userOption = 0;
            Name name = null;

            try (Scanner data = new Scanner(new File(fileName))) {
                directory.readFile(data);
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }

            while (userOption != 5) {
                System.out.println("Please select an option:");
                System.out.println("1. Show all contacts");
                System.out.println("2. Look up a contact");
                System.out.println("3. Add a contact");
                System.out.println("4. Remove a contact");
                System.out.println("5. Close");
                System.out.print(">> ");
                userOption = input.nextInt();

                switch (userOption) {
                    case 1:
                        System.out.println(directory.getPhoneBook());
                        break;
                    case 2:
                        name = getName();
                        System.out.println(name);
                        if (name.equals(INPUT_ERROR)) {
                            System.out.println("Error in entering name. Please try again.");
                        } else {
                            String phoneNumber = directory.getPhoneNumber(name);
                            if (phoneNumber == null) {
                                System.out.println(name + " is not in the directory.");
                            } else {
                                System.out.println("The phone number for " + name + " is " +
                                        phoneNumber);
                            }
                        }
                        break;
                    case 3:
                        name = getName();
                        if (name.equals(INPUT_ERROR)) {
                            System.out.println("Error in entering name. Please try again.");
                        } else {
                            String phoneNumber = getPhoneNumber();
                            if (phoneNumber.equals("error")) {
                                System.out.println("Error in entering phone number. " +
                                        "Please try again.");
                            } else {
                                directory.addPhoneNumber(name, phoneNumber);
                                System.out.println("Successfully added " + name +
                                        " to your contacts.");
                            }
                        }
                        break;
                    case 4:
                        name = getName();
                        if (name.equals(INPUT_ERROR)) {
                            System.out.println("Error in entering name. Please try again.");
                        } else {
                            String phoneNumber = directory.getPhoneNumber(name);
                            if (phoneNumber == null) {
                                System.out.println(name + " is not in the directory.");
                            } else {
                                directory.removePhoneNumber(name);
                                System.out.println("Successfully removed " + name +
                                        " from your contacts.");
                            }
                        }
                        break;
                    case 5:
                        try (PrintWriter output = new PrintWriter(new File(fileName))) {
                            directory.writeFile(output);
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + e.getMessage());
                        }

                }
            }
        }

        private static Name getName() {
            Name result = null;
            Scanner input = new Scanner(System.in);
            System.out.print("Enter first name and last name: ");
            String line = input.nextLine();

            String firstName = null;
            String lastName = null;
            Scanner scan = new Scanner(line);

            if (scan.hasNext()) {
                firstName = scan.next();
                if (scan.hasNext()) {
                    lastName = scan.next();
                } else {
                    result = INPUT_ERROR;
                }
            } else {
                result = INPUT_ERROR;
            }
            if (result == null) {
                result = new Name(firstName, lastName);
            }

            return result;
        }

        private static String getPhoneNumber() {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter phone Number (xxx-xxx-xxxx): ");
            String line = input.next();
            String pattern = "\\d{3}-\\d{3}-\\d{4}";

            if (line.matches(pattern)) {
                return line;
            } else {
                return "error";
            }
        }
    }

}
