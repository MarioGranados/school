package InClass.Lab10_MarioGranados;

import java.util.ArrayList;

public class PriorityQueue {

    ArrayList<Node> queue;

    public PriorityQueue(ArrayList<Node> list) {
        queue = new ArrayList<>(list);

        // max heap
        for (int i = (queue.size() / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // add
    public void add(Node n) {
        queue.add(n);

        // Re-heapify 
        for (int i = (queue.size() / 2) - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // remove
    public Node remove() {
        if (queue.isEmpty()) {
            return null;
        }

        Node root = queue.get(0);

        Node last = queue.remove(queue.size() - 1);

        if (!queue.isEmpty()) {
            queue.set(0, last);
            heapify(0);
        }

        return root;
    }

    // HEAPIFY
    private void heapify(int i) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < queue.size()
                && queue.get(left).getPriority() > queue.get(largest).getPriority()) {
            largest = left;
        }

        if (right < queue.size()
                && queue.get(right).getPriority() > queue.get(largest).getPriority()) {
            largest = right;
        }

        // swap
        if (largest != i) {
            Node temp = queue.get(i);
            queue.set(i, queue.get(largest));
            queue.set(largest, temp);

            heapify(largest);
        }
    }

    // print
    public void printQueue() {
        for (Node n : queue) {
            System.out.print(n.getPriority() + " ");
        }
        System.out.println();
    }
}
