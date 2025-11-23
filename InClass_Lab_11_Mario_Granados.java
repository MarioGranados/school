import java.util.ArrayList;

public class InClass_Lab_11_Mario_Granados {

    // class
    static class Node {
        int priority;
        String data;
        Node next;

        Node(int priority, String data) {
            this.priority = priority;
            this.data = data;
            this.next = null;
        }
    }

    // qeueue
    static Node head = null;

    // add to the end
    public static void enqueue(int priority, String data) {
        Node newNode = new Node(priority, data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // insertion sort
    public static void insertionSort() {
        if (head == null || head.next == null) return;

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || current.priority > sorted.priority) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.priority >= current.priority) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }

        head = sorted;
    }

    // print sorted qeueue
    public static void printQueue() {
        insertionSort();

        System.out.println("Priority Queue contents highest pirority to lowest:");
        Node temp = head;
        while (temp != null) {
            System.out.println("Priority: " + temp.priority + ", Data: " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        enqueue(5, "Task A");
        enqueue(1, "Task B");
        enqueue(3, "Task C");
        enqueue(10, "Urgent Task");
        enqueue(7, "Task D");

        printQueue();
    }
}
