package InClass.Lab10_MarioGranados;

import java.util.ArrayList;

public class InClassMain {

    public static void main(String args[]) {
        ArrayList<Node> list = new ArrayList<>();;

        list.add(new Node(2));
        list.add(new Node(4));
        list.add(new Node(7));
        list.add(new Node(13));
        list.add(new Node(5));
        list.add(new Node(15));
        list.add(new Node(8));

        PriorityQueue queue = new PriorityQueue(list);

        queue.printQueue(); // 15 13 8 7 5 4 2
    }
}
