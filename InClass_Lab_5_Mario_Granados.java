import java.util.ArrayList;

public class InClass_Lab_5_Mario_Granados {
    public static void main(String[] args) {
        RawQueue<Integer> rq = new RawQueue<>();
        RawQueue<Character> rqChar = new RawQueue<>();
        RawQueue<Packet> rqPacket = new RawQueue<>();
    }
}

class Packet {
    private String data;
    private int position;

    public Packet(String data, int position) {
        this.data = data;
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getData() {
        return this.data;
    }

}

class RawQueue<T> {
    private ArrayList<T> list;
    private ArrayList<T> list2;

    public RawQueue() {
        list = new  ArrayList<>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public void dequeue() {
        list2.add(list.remove(0));
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}