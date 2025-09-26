import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lab_4_Mario_Granados {
    public static void main(String[] args) {
        int maxSize = 30;
        List<Integer> tasks = generateRandomList(maxSize);
        int[] queue = new int[3];

        System.out.println("This is the list of all the " + tasks.size() + " Task(s) to be done!");
        System.out.println(tasks);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < maxSize; i++) {
            System.out.println("Time unit: " + (i + 1));

            for (int u = 0; u < 3; u++) {
                if (queue[u] > 0) {
                    queue[u]--;
                    System.out.println("Processor " + (u + 1) + " decremented -> " + queue[u] + " remaining");
                    if (queue[u] == 0) {
                        System.out.println("Processor " + (u + 1) + " finished its task");
                    }
                } else {
                    System.out.println("Processor " + (u + 1) + " is idle");
                }
            }

            for (int u = 0; u < 3; u++) {
                if (queue[u] == 0 && !tasks.isEmpty()) {
                    int newTask = tasks.remove(0);
                    queue[u] = newTask;
                    System.out.println("Assigned new task (" + newTask + ") to processor " + (u + 1));
                    break;
                }
            }

            System.out.println("Remaining tasks in queue: " + tasks.size());
            System.out.println("=======================================");
        }

        // while(!tasks.isEmpty()) {
        // int currentTask = tasks.get(0);
        // System.out.println("Current Task: " + currentTask);
        // if(tasks.get(0) > 0) {
        // tasks.set(0, tasks.get(0) - 1);
        // } else {
        // System.out.println("Task: Completed");
        // tasks.remove(0);
        // }
        // }

    }

    public static List<Integer> generateRandomList(int listMaxSize) {
        Random random = new Random();
        List<Integer> tasks = new ArrayList<>();

        for (int i = 0; i < listMaxSize; i++) {
            int randomNum = random.nextInt(5 - 1 + 1) + 1;
            tasks.add(randomNum);
        }
        return tasks;
    }
}
