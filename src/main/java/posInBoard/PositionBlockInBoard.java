package posInBoard;

public class PositionBlockInBoard {
    int x;
    int y;
    int height;
    int width;
    int type;

    public PositionBlockInBoard(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "posInBoard.PositionBlockInBoard{" +
                "x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
