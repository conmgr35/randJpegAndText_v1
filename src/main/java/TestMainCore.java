import me.xdrop.jrand.JRand;

import java.util.ArrayList;
import java.util.stream.Stream;

public class TestMainCore {


    public static void main(String[] args) {
        PositionOnBoard positionOnBoard = new PositionOnBoard();

        while (positionOnBoard.isFreeSpace()) {
            int randInt = JRand.natural().min(1).max(3).gen();
            System.out.println("______________________________");
            System.out.println(randInt);
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

        Stream.of(positionOnBoard.getArrayBlock()).forEach(System.out::println);
    }


}

class Blockk {
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Blockk(int startX, int startY, int endX, int endY) {
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

    @Override
    public String toString() {
        return "Block{" +
                "startX=" + startX +
                ", startY=" + startY +
                ", endX=" + endX +
                ", endY=" + endY +
                '}';
    }
}

class PositionOnBoard {
    private boolean[][] isFreeSpaceOnBoard = new boolean[10][10];
    private ArrayList<Blockk> arrayBlock = new ArrayList<Blockk>();

    public void getFreeSpace(int height, int width) {
        int w = width / 200;
        int h = height / 200;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                try {
                    if (h == 1 && w == 1) {
                        if ((i + 1 < 10) && (j + 1 < 10)) {

                            if (isFreeSpaceOnBoard[i][j] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 0] == false &&
                                    isFreeSpaceOnBoard[i + 0][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 1] == false) {
                                System.out.println("good");
                                if ((((9 - (i + 1)) >= 2) && ((9 - (j + 1)) >= 2)) || (((9 - (i + 1)) == 0) || ((9 - (j + 1)) == 0))) {
                                    if (((i > 0) && (isFreeSpaceOnBoard[i - 1][j]) == true) || i == 0) {
                                        if (((j > 0) && (isFreeSpaceOnBoard[i][j - 1]) == true) || j == 0) {
                                            isFreeSpaceOnBoard[i][j] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 0] = true;
                                            isFreeSpaceOnBoard[i + 0][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 1] = true;

                                            arrayBlock.add(new Blockk(i * 200, j * 200, (i + 1) * 200, (j + 1) * 200));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }


                    if (h == 2 && w == 2) {
                        if ((i + 2 < 10) && (j + 2 < 10)) {
                            if (isFreeSpaceOnBoard[i][j] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 0] == false &&
                                    isFreeSpaceOnBoard[i + 0][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 0] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 0][j + 2] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 2] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 2] == false) {
                                System.out.println("good");
                                if ((((9 - (i + 2)) >= 2) && ((9 - (j + 2)) >= 2)) || (((9 - (i + 2)) == 0) || ((9 - (j + 2)) == 0))) {
                                    if (((i > 0) && (isFreeSpaceOnBoard[i - 1][j]) == true) || i == 0) {
                                        if (((j > 0) && (isFreeSpaceOnBoard[i][j - 1]) == true) || j == 0) {

                                            isFreeSpaceOnBoard[i][j] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 0] = true;
                                            isFreeSpaceOnBoard[i + 0][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 0] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 0][j + 2] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 2] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 2] = true;


                                            arrayBlock.add(new Blockk(i * 200, j * 200, (i + 2) * 200, (j + 2) * 200));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (h == 2 && w == 3) {
                        if ((j + 2 < 10) && (i + 3 < 10)) {
                            if (isFreeSpaceOnBoard[i][j] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 0] == false &&
                                    isFreeSpaceOnBoard[i + 0][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 0] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 1] == false &&
                                    isFreeSpaceOnBoard[i + 0][j + 2] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 2] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 2] == false &&
                                    isFreeSpaceOnBoard[i + 0][j + 3] == false &&
                                    isFreeSpaceOnBoard[i + 1][j + 3] == false &&
                                    isFreeSpaceOnBoard[i + 2][j + 3] == false) {
                                System.out.println("good");
                                if ((((9 - (i + 2)) >= 2) && ((9 - (j + 3)) >= 2)) || (((9 - (i + 2)) == 0) || ((9 - (j + 3)) == 0))) {
                                    if (((i > 0) && (isFreeSpaceOnBoard[i - 1][j]) == true) || i == 0) {
                                        if (((j > 0) && (isFreeSpaceOnBoard[i][j - 1]) == true) || j == 0) {

                                            isFreeSpaceOnBoard[i][j] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 0] = true;
                                            isFreeSpaceOnBoard[i + 0][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 0] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 1] = true;
                                            isFreeSpaceOnBoard[i + 0][j + 2] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 2] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 2] = true;
                                            isFreeSpaceOnBoard[i + 0][j + 3] = true;
                                            isFreeSpaceOnBoard[i + 1][j + 3] = true;
                                            isFreeSpaceOnBoard[i + 2][j + 3] = true;


                                            arrayBlock.add(new Blockk(i * 200, j * 200, (i + 2) * 200, (j + 3) * 200));
                                            return;
                                        }
                                    }
                                }
                            }
                        }

                    }


                } catch (Exception e) {
                    System.out.println(e);
                    return;

                }

            }
        }

    }

    public ArrayList<Blockk> getArrayBlock() {
        return arrayBlock;
    }

    boolean isFreeSpace() {
        System.out.println("___________________________________________________________________________________");
        for (int i = 0; i < isFreeSpaceOnBoard.length; i++) {
            for (int j = 0; j < isFreeSpaceOnBoard.length; j++) {
                System.out.print((isFreeSpaceOnBoard[i][j] == false ? "\033[0m" : "\033[0;32m") + "\t[" + i + "]" + " [" + j + "] " + isFreeSpaceOnBoard[i][j]);
            }
            System.out.print("\r\n");
        }

        for (int i = 0; i < isFreeSpaceOnBoard.length; i++) {
            for (int j = 0; j < isFreeSpaceOnBoard.length; j++) {
                if (isFreeSpaceOnBoard[i][j] == false)
                    return true;
            }
        }
        return false;
    }

}