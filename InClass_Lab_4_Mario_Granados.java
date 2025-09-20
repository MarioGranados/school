import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InClass_Lab_4_Mario_Granados {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> toDoList = new ArrayList<>();

        while(true) {
            System.out.print("Enter Something for me to do!");
            String task = input.nextLine();
            if(task.equalsIgnoreCase("done")){
                break;
            } 
            toDoList.add(task);
        }

        while(!toDoList.isEmpty()) {
            String currentTask = toDoList.get(0);
            System.out.println(currentTask);
            System.out.println("Press enter to complete of task");
            input.nextLine();
            toDoList.remove(0);
        }
        System.out.println("Everything is done!");
    }
    
}
