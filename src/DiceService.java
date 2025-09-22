package src;

public class DiceService {
	private final java.util.Random random = new java.util.Random();

	public int roll() {
		return 1 + random.nextInt(6);
	}

	public int roll(int numberOfDice) {
		int sum = 0;
		for (int i = 0; i < numberOfDice; i++) {
			sum += 1 + random.nextInt(6);
		}
		return sum;
	}
}
