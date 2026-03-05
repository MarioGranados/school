package InClass.Lab5_Mario_Granados;

import java.util.ArrayList;

public class Machine {

    private ArrayList<Packet> buffer;
    private ArrayList<Packet> memory;

    public Machine() {

        this.buffer = new ArrayList<>();
        this.memory = new ArrayList<>();

    }

    public void enqueue(Packet packet) {
        buffer.add(packet);
    }

    public void dequeue() {
        Packet packet = buffer.get(0);
        buffer.remove(0);
        for(int i = 0; i < memory.size(); i++) {
            if(packet.getPosition() < memory.get(i).getPosition()) {
                memory.add(i, packet);
                return;
            }
        }
        memory.add(packet);
        
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public ArrayList<Packet> getMemory() {
        return this.memory;
    }
}
