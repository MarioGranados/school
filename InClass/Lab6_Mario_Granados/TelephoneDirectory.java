package InClass.Lab6_Mario_Granados;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelephoneDirectory {

    private Map<Name, String> phoneBook;

    public TelephoneDirectory() {
        phoneBook = new HashMap<>();
    }

    public void readFile(Scanner data) {

        while (data.hasNext()) {

            String firstName = data.next();
            String lastName = data.next();
            String phoneNumber = data.next();

            Name name = new Name(firstName, lastName);

            phoneBook.put(name, phoneNumber);
        }
    }

    public String getPhoneNumber(Name name) {

        return phoneBook.get(name);
    }

    public void addPhoneNumber(Name name, String phoneNumber) {

        phoneBook.put(name, phoneNumber);
    }

    public void removePhoneNumber(Name name) {

        phoneBook.remove(name);
    }

    public void writeFile(PrintWriter output) {

        for (Map.Entry<Name, String> entry : phoneBook.entrySet()) {

            Name name = entry.getKey();
            String phoneNumber = entry.getValue();

            output.println(
                    name.getFirstName() + " "
                    + name.getLastName() + " "
                    + phoneNumber
            );
        }
    }

    public String getPhoneBook() {

        String result = "";

        for (Map.Entry<Name, String> entry : phoneBook.entrySet()) {

            result += entry.getKey() + " : "
                    + entry.getValue() + "\n";
        }

        return result;
    }
}
