package InClass.Lab9_MarioGranados;

import java.io.File;
import java.util.Scanner;

public class DirectoryListerRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a directory path: ");
        String path = scanner.nextLine().trim();

        File root = new File(path);

        if (!root.exists()) {
            System.out.println("Error: The path does not exist.");
            return;
        }

        if (!root.isDirectory()) {
            System.out.println("Error: The path is not a directory.");
            return;
        }

        System.out.println("\nDirectory Tree:");
        printDirectory(root, 0);

        scanner.close();
    }

    public static void printDirectory(File dir, int level) {
        File[] contents = dir.listFiles();

        if (contents == null || contents.length == 0) {
            printIndent(level);
            System.out.println("(empty)");
            return;
        }

        for (File file : contents) {
            printIndent(level);

            if (file.isDirectory()) {
                System.out.println("[DIR] " + file.getName());
                printDirectory(file, level + 1); 
            } else {
                System.out.println("[FILE] " + file.getName());
            }
        }
    }

    public static void printIndent(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
    }
}
