import me.xdrop.jrand.JRand;

import java.util.ArrayList;
import java.util.stream.Stream;

public class TestMainPositionPx {
    public static void main(String[] args) {
        CorePosition corePosition = new CorePosition();


        while (corePosition.isFreeSpace()) {
            switch (JRand.natural().min(1).max(3).gen()) {
                case 1:
                    corePosition.calcPosition(200, 200);
                    System.out.println(200 + " " + 200);
                    break;
                case 2:
                    corePosition.calcPosition(400, 400);
                    System.out.println(400 + " " + 400);
                    break;
                case 3:
                    corePosition.calcPosition(400, 600);
                    System.out.println(400 + " " + 600);
                    break;
            }
            corePosition.seeArray();

        }

//        int sumWidth = 1000, sumHeight = 1000;
////        ArrayList<Blockk> blocks = new ArrayList<>();
//
//
//
//            while (sumWidth > 0 && sumWidth > 0) {
//                int randWidth = 0, randHeight = 0;
//                int randInt = JRand.natural().min(1).max(3).gen();
//                switch (randInt) {
//                    case 1:
//                        randHeight = 200;
//                        randWidth = 200;
//                        break;
//                    case 2:
//                        randHeight = 400;
//                        randWidth = 400;
//                        break;
//                    case 3:
//                        randHeight = 400;
//                        randWidth = 600;
//                        break;
//                }
//                if (
//                        (((randHeight < sumHeight) && (randWidth < sumWidth)) && ((sumHeight - randHeight > 200) && (sumWidth - randWidth > 200)))
//                                || ((sumWidth - randWidth == 0) && (sumHeight - randHeight == 0))) {
//                    System.out.println(randHeight + " " + randWidth);
//                    sumHeight -= randHeight;
//                    sumWidth -= randWidth;
//                    switch (randInt) {
//                        case 1:
//                            corePosition.calcPosition(200, 200);
//                            break;
//                        case 2:
//                            corePosition.calcPosition(400, 400);
//                            break;
//                        case 3:
//                            corePosition.calcPosition(400, 600);
//                            break;
//                    }
//                }
//            }
//
//


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
        System.out.println("___________________________________________");
        corePosition.seeArray();
//        for (Blockk bk : blocks) {
//            System.out.println(bk.toString());
//        }


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

    void seeArray() {
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
}
