import java.util.Scanner;

public class Lab3Solution {
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		Scanner input = new Scanner(System.in);

		while (!myDeck.isEmpty()) {
			System.out.println(myDeck.pop());
			System.out.println("Press enter to hit.");
			input.nextLine();
		}
	}
}
