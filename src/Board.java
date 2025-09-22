package src;
public class Board {
    private IBoardEntity[][] boardEntities;
    private int size;
    public Board(int size, IBoardEntity[][] boardEntities) {
        this.size = size;
        this.boardEntities = boardEntities;
    }
    public int getSize(){
        return size;
    }
    public IBoardEntity getEntityAtStart(int start){
        if(start < 1 || start > size*size) return null;
        int zero = start - 1;
        int row = zero / size;
        int col = zero % size;
        return boardEntities[row][col];
    }
}
