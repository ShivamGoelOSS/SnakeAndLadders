package src;

public class Client {
	public static void main(String[] args) {
		GameBuilder builder = new GameBuilder()
			.setBoardFactory(new BoardFactory())
			.setSize(10)
			.setNumLadders(5)
			.setNumSnakes(5)
			.setDiceService(new DiceService())
			.setPlayer1(new HumanPlayer())
			.setPlayer2(new HumanPlayer());
		Game game = builder.build();
		System.out.println("Starting game: ");
		game.start();
	}
}
