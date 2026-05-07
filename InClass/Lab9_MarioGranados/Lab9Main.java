package InClass.Lab9_MarioGranados;

import java.io.File;
import java.util.Scanner;

public class Lab9Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory to search in:");
        String directoryPath = scanner.nextLine().trim();

        System.out.print("Enter file or folder name to search for");
        String targetName = scanner.nextLine().trim();

        File root = new File(directoryPath);

        if (!root.exists()) {
            System.out.println("Error did not found dir");
            return;
        }

        if (!root.isDirectory()) {
            System.out.println("paht does not exist");
            return;
        }

        String result = searchDFS(root, targetName);

        if (result != null) {
            System.out.println("FOUND " + result);
        } else {
            System.out.println("NOT FOUND " + targetName);
        }

        scanner.close();
    }

    public static String searchDFS(File current, String targetName) {

        if (current.getName().equals(targetName)) {
            return current.getAbsolutePath();
        }

        if (current.isDirectory()) {
            File[] children = current.listFiles();

            if (children != null) {
                for (File child : children) {
                    String result = searchDFS(child, targetName);

                    if (result != null) {
                        return result; // found
                    }
                }
            }
        }

        return null; // return if not here
    }
}
