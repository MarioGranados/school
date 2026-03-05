package InClass.InClass_4_Mario_Granados;

import java.util.Random;

public class Lab4 {

    public static int[] buildTasks(int[] array) {
        Random rand = new Random();

        int min = 1;
        int max = 5;

        // The formula is rand.nextInt((max - min) + 1) + min;
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
        return array;
    }

    public static void printTasks(int[] units) {
        System.out.println("Current units:");
        for (int k = 0; k < units.length; k++) {
            System.out.println("Unit " + (k + 1) + ": " + units[k]);
        }
        System.out.println("--------------------");
    }

    // taskIndex is the pointer or where you want to start within the queue, should be zero for the asignment
    //timeInterval is suppose to simulate the time it takes to complete task, assigmnet says 30
    public static void queueProcessing(int[] task, int taskIndex, int[] units, int timeInterval) {
        for (int c = 0; c < timeInterval; c++) {

            if (taskIndex < task.length) {
                System.out.println("Next task is: " + task[taskIndex]);
            } else {
                System.out.println("No tasks left in queue.");
            }

            for (int j = 0; j < units.length; j++) {
                if (units[j] > 0) {
                    units[j]--;
                    System.out.println();

                }
                System.out.println("Completing current tasks...");
                System.out.println("updated tasks");
            }

            for (int i = 0; i < units.length; i++) {
                if (units[i] == 0 && taskIndex < task.length) { 
                    units[i] = task[taskIndex];
                    System.out.println();
                    System.out.println("Assigned task " + task[taskIndex] + " to unit " + (i + 1));
                    taskIndex++; //pointer index
                    printTasks(units);
                }

            }

        }
    }

    public static void main(String[] args) {

        int[] task = new int[50];
        int numberOfUnits = 8;
        task = buildTasks(task);
        int[] units = new int[numberOfUnits];

        queueProcessing(task, 0, units, 30);
        queueProcessing(task, 0, units, 10);

    }
}