package test;

import java.io.File;
import java.util.Scanner;

public class Lab_10_Mario_Granados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // grab name of directory
        System.out.print("Enter folder name to search within: ");
        String dirName = scanner.nextLine();

        File directory = new File(dirName);

        // if value then we found something
        if (!directory.exists()) {
            System.out.println("Error: The folder does not exist.");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Error: That is not a folder.");
            return;
        }
        if (directory.listFiles() == null || directory.listFiles().length == 0) {
            System.out.println("Error: The folder is empty.");
            return;
        }

        //file to search for
        System.out.print("Enter file or folder name to search for: ");
        String target = scanner.nextLine();

        String result = searchFile(directory, target);

        if (result != null) {
            System.out.println("FOUND at: " + result);
        } else {
            System.out.println("Not found.");
        }

        scanner.close();
    }

    // recurcive search
    public static String searchFile(File dir, String targetName) {
        File[] files = dir.listFiles();
        if (files == null) return null;

        for (File file : files) {
            if (file.getName().equalsIgnoreCase(targetName)) {
                return file.getAbsolutePath();
            }

            if (file.isDirectory()) {
                String found = searchFile(file, targetName);
                if (found != null) return found;
            }
        }
        return null;
    }
}

