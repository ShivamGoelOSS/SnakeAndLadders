package src;

public class SnakeEntity implements IBoardEntity {
    public int start;
    public int end;
    public SnakeEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
}
