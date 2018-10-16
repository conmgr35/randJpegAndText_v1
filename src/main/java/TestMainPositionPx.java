import me.xdrop.jrand.JRand;

import java.util.ArrayList;
import java.util.stream.Stream;

public class TestMainPositionPx {
    public static void main(String[] args) {
        CorePosition corePosition = new CorePosition();

        int sum = 1000 * 1000;
        ArrayList<Blockk> blocks = new ArrayList<>();
        while (sum > 0) {
            int rand = 0;
            int randInt = JRand.natural().min(1).max(3).gen();
            switch (randInt) {
                case 1:
                    rand = 200 * 200;
                    break;
                case 2:
                    rand = 400 * 400;
                    break;
                case 3:
                    rand = 400 * 600;
                    break;
            }
            if (((rand < sum) && (sum - rand > 40000)) || (sum - rand == 0)) {
                sum -= rand;
                switch (randInt) {
                    case 1:
                        corePosition.calcPosition(200, 200);
                        break;
                    case 2:
                        corePosition.calcPosition(400, 400);
                        break;
                    case 3:
                        corePosition.calcPosition(400, 600);
                        break;
                }
            }


        }


//        corePosition.calcPosition(200, 200);
//        corePosition.calcPosition(200, 200);
//
//        corePosition.calcPosition(200, 200);
//        corePosition.calcPosition(400, 400);
//        corePosition.calcPosition(400, 600);
//        corePosition.calcPosition(400, 600);
//        corePosition.calcPosition(400, 600);
//        corePosition.calcPosition(400, 400);
//        corePosition.calcPosition(200, 200);
        corePosition.seeArray();
        for (Blockk bk : blocks) {
            System.out.println(bk.toString());
        }


    }


}

class CorePosition {

    int[][] iFreeSpace = new int[1000][1000];

    public CorePosition() {
        for (int i = 0; i < iFreeSpace.length; i++) {
            for (int j = 0; j < iFreeSpace.length; j++) {
                iFreeSpace[i][j] = 0;
            }
        }
    }

    void calcPosition(int height, int width) {
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

    void seeArray() {
        for (int i = 0; i < iFreeSpace.length; i += 100) {
            for (int j = 0; j < iFreeSpace.length; j += 100) {
                if (iFreeSpace[i][j] == 0) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }
}
