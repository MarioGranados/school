import java.util.ArrayList;

public class Lab_5_Mario_Granados {

    class Machine {
        private ArrayList<Packet> buffer;
        private ArrayList<Packet> memory;

        private Machine() {
            buffer = new ArrayList<>();
            memory = new ArrayList<>();
        }

        public void enqueue(Packet p) {
            buffer.add(p);
        }

        public void dequeue() {
            if (buffer.isEmpty())
                return;

            Packet packet = buffer.remove(0);

            if (memory.isEmpty()) {
                memory.add(packet);
                return;
            }

            int i = memory.size() - 1;

            memory.add(null);

            while (i >= 0 && memory.get(i).getPosition() > packet.getPosition()) {
                memory.set(i + 1, memory.get(i));
                i--;
            }
            memory.set(i + 1, packet);
        }

        public boolean isEmpty() {
            return buffer.isEmpty();
        }

        public ArrayList<Packet> getMemory() {
            return this.memory;
        }
    }

    public static void main(String[] args) {
        Packet p1 = new Packet("Why", 1);
        Packet p2 = new Packet("Am", 2);
        Packet p3 = new Packet("I", 3);
        Packet p4 = new Packet("Taking", 4);
        Packet p8 = new Packet("This", 5);
        Packet p7 = new Packet("Class", 6);
        Packet p6 = new Packet("This", 7);
        Packet p5 = new Packet("Semester", 8);

        Machine m = new Lab_5_Mario_Granados().new Machine();

        m.enqueue(p1);
        m.enqueue(p3);
        m.enqueue(p2);
        m.enqueue(p4);
        m.enqueue(p8);
        m.enqueue(p7);
        m.enqueue(p5);
        m.enqueue(p6);

        while (!m.isEmpty()) {
            m.dequeue();
        }
        m.getMemory().forEach(packet -> {
            System.out.println("Packet Position: " + packet.getPosition() +
                    " Data: " + packet.getData());
        });
    }
}
