package src;
public class Game{
    public GameBuilder builder;
    private Board board;
    private IPlayer player1;
    private IPlayer player2;
    private DiceService diceService;
    private int player1Pos = 0;
    private int player2Pos = 0;
    public Game(GameBuilder builder){
        this.builder = builder;
        this.board = builder.getBoardFactory().createBoard(builder.getSize(), builder.getNumLadders(), builder.getNumSnakes());
        this.player1 = builder.getPlayer1();
        this.player2 = builder.getPlayer2();
        this.diceService = builder.getDiceService();
    }

    public void start(){
        int goal = board.getSize() * board.getSize();
        boolean p1Turn = true;
        while(true){
            int roll = diceService != null ? diceService.roll() : 1;
            if(p1Turn){
                if(player1 != null) player1.makeMove();
                player1Pos = moveAndResolve(player1Pos, roll, goal);
                System.out.println("Player 1 rolled " + roll + ", moved to " + player1Pos);
                if(player1Pos == goal){
                    System.out.println("Player 1 wins!");
                    break;
                }
            } else {
                if(player2 != null) player2.makeMove();
                player2Pos = moveAndResolve(player2Pos, roll, goal);
                System.out.println("Player 2 rolled " + roll + ", moved to " + player2Pos);
                if(player2Pos == goal){
                    System.out.println("Player 2 wins!");
                    break;
                }
            }
            p1Turn = !p1Turn;
        }
    }

    private int moveAndResolve(int current, int roll, int goal){
        int next = current + roll;
        if(next > goal) return current; // must land exactly
        IBoardEntity entity = board.getEntityAtStart(next);
        if(entity != null){
            int start = entity.getStart();
            int end = entity.getEnd();
            if(end > start){
                System.out.println("Ladder from " + start + " to " + end);
            } else if(end < start){
                System.out.println("Snake from " + start + " to " + end);
            }
            next = end;
        }
        return next;
    }
}