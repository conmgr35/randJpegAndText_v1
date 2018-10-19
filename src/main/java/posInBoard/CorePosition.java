package posInBoard;

import java.util.ArrayList;

public class CorePosition {
    ArrayList<PositionBlockInBoard> posit = new ArrayList<>();
    int[][] iFreeSpace = new int[1000][1000];

    public CorePosition() {
        for (int i = 0; i < iFreeSpace.length; i++) {
            for (int j = 0; j < iFreeSpace.length; j++) {
                iFreeSpace[i][j] = 0;
            }
        }
    }

    public void calcPosition(int height, int width) {
        for (int i = 0; i < iFreeSpace.length; i++) {
            for (int j = 0; j < iFreeSpace.length; j++) {
                if (iFreeSpace[i][j] == 0) {
                    if ((i + height <= iFreeSpace.length) && (j + width <= iFreeSpace.length)) {
                        if (isPositionFree(i, j, height, width)) {
                            setInPosition(i, j, height, width);
                            return;
                        }
                    }
                }
            }
        }

    }

    private void setInPosition(int x, int y, int height, int width) {
        posit.add(new PositionBlockInBoard(x,y,height,width));
        for (int i = x; i < x + height; i++) {
            for (int j = y; j < y + width; j++) {
                iFreeSpace[i][j] = 1;
            }
        }

    }

    private boolean isPositionFree(int x, int y, int height, int width) {
        boolean isEnd = true;
        for (int i = x; i < x + height; i++) {
            for (int j = y; j < y + width; j++) {
                if (iFreeSpace[i][j] == 1) {
                    isEnd = false;
                }
            }
        }
        return isEnd;
    }

    public boolean isFreeSpace() {
        for (int i = 0; i < iFreeSpace.length; i++) {
            for (int j = 0; j < iFreeSpace.length; j++) {
                if (iFreeSpace[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void seeArray() {
        for (int i = 0; i < iFreeSpace.length; i += 100) {
            for (int j = 0; j < iFreeSpace.length; j += 100) {
                if (iFreeSpace[i][j] == 0) {
                    System.out.print(" \033[0m- ");
                } else {
                    System.out.print(" \033[0;32m+ ");
                }
            }
            System.out.println("\033[0m");
        }
    }

    public void seeBlockArray(){
        for(PositionBlockInBoard positionBlockInBoard: posit){
            System.out.println(positionBlockInBoard.toString());
        }
    }

}
