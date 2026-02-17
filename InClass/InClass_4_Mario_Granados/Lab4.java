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

    public static void printArray(int[] array, int unitNumber) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Task with time: " + array[i] + " assignemd to unit " + unitNumber);
        }
    }

    public static void printArray(int[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Task with time: " + array[i]);
        }
    }

    public static void main(String[] args) {

        int[] tasks = new int[50];
        int taskIndex = 0;
        tasks = buildTasks(tasks);

        int[] queue = new int[3];
        int pointer = 0;

        for (int i = 0; i < queue.length; i++) {
            queue[i] = tasks[taskIndex];
            taskIndex++;
        }
        while(true) {
            if(queue[0] != 0 && queue[1] != 0 && queue[2] != 0) {
                break;
            }
            if(pointer >= 2) {
                pointer = 0;
            }

            if(queue[pointer] == 0) {
                queue[pointer] = tasks[taskIndex];
                taskIndex++;
                pointer++;
                System.out.println("Added new Task");

                printArray(queue, 1);
            } else {
                queue[pointer] = queue[pointer] - 1;
                printArray(queue, 1);
            }

        }



        printArray(queue, 1);

    }
}