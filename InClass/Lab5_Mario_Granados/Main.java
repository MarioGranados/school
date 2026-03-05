package InClass.Lab5_Mario_Granados;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		ArrayList<Packet> transmittedFile = new ArrayList<>();
		Machine destination = new Machine();

		for (int index = 0; index < 10; index++) {
			transmittedFile.add(new Packet("Data for packet " + (index + 1), index + 1));
		}

		Collections.shuffle(transmittedFile);

		while (!transmittedFile.isEmpty()) {
			destination.enqueue(transmittedFile.remove(0));
		}

		while (!destination.isEmpty()) {
			destination.dequeue();
		}

		ArrayList<Packet> fileFromMemory = destination.getMemory();

		while (!fileFromMemory.isEmpty()) {
			System.out.println(fileFromMemory.remove(0).getData());
		}
	}
}