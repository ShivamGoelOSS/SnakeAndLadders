package src;
public class GameBuilder {
    private BoardFactory boardFactory;
    private IPlayer player1;
    private IPlayer player2;
    private DiceService diceService;
    int size;
    int numLadders;
    int numSnakes;
    public GameBuilder setBoardFactory(BoardFactory boardFactory){
        this.boardFactory = boardFactory;
        return this;
    }
    public GameBuilder setPlayer1(IPlayer player1){
        this.player1 = player1;
        return this;
    }
    public GameBuilder setPlayer2(IPlayer player2){
        this.player2 = player2;
        return this;
    }
    public GameBuilder setDiceService(DiceService diceService){
        this.diceService = diceService;
        return this;
    }
    public GameBuilder setSize(int size){
        this.size = size;
        return this;
    }
    public GameBuilder setNumLadders(int numLadders){
        this.numLadders = numLadders;
        return this;
    }
    public GameBuilder setNumSnakes(int numSnakes){
        this.numSnakes = numSnakes;
        return this;
    }
    public Game build(){
        return new Game(this);
    }

    public BoardFactory getBoardFactory() {
        return boardFactory;
    }

    public IPlayer getPlayer1() {
        return player1;
    }

    public IPlayer getPlayer2() {
        return player2;
    }

    public DiceService getDiceService() {
        return diceService;
    }

    public int getSize() {
        return size;
    }

    public int getNumLadders() {
        return numLadders;
    }

    public int getNumSnakes() {
        return numSnakes;
    }
}
