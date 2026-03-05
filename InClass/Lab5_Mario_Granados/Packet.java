package InClass.Lab5_Mario_Granados;

public class Packet {

    private String data;
    private int position;

    public Packet(String data, int position) {
        this.data = data;
        this.position = position;
    }

    public String getData() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }
}