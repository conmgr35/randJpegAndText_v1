import me.xdrop.jrand.JRand;

public class TestMainCore {


    public static void main(String[] args) {
        PositionOnBoard positionOnBoard = new PositionOnBoard();
        int randInt = JRand.natural().min(1).max(3).gen();

        switch (randInt) {
            case 1:
                positionOnBoard.getFreeSpace(200, 200);
                break;
            case 2:
                positionOnBoard.getFreeSpace(400, 400);
                break;
            case 3:
                positionOnBoard.getFreeSpace(400, 600);
                break;
        }
    }


}

class Block {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Block(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}

class PositionOnBoard {
    boolean[][] isFreeSpaceOnBoard = new boolean[5][5];

    public void getFreeSpace(int width, int height) {
        System.out.println();
    }

    boolean isFreeSpace() {
        for (int i = 0; i < isFreeSpaceOnBoard.length; i++) {
            for (int j = 0; j < isFreeSpaceOnBoard.length; j++) {
                if (isFreeSpaceOnBoard[i][j] == true)
                    return true;
            }
        }
        return false;
    }

}