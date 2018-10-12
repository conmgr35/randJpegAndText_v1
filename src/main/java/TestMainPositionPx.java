public class TestMainPositionPx {
    public static void main(String[] args) {
        CorePosition corePosition = new CorePosition();
        corePosition.calcPosition(400, 600);
        corePosition.calcPosition(200, 200);
        corePosition.calcPosition(400, 400);
        corePosition.seeArray();
    }


}

class CorePosition {

    int[][] iFreeSpace = new int[1000][1000];

    void calcPosition(int height, int width) {

        for (int i = 0; i < iFreeSpace.length; i++) {
            for (int j = 0; j < iFreeSpace.length; j++) {
                if (iFreeSpace[i][j] != 1) {
                    if ((i + height < iFreeSpace.length) && (j + width < iFreeSpace.length)) {
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
        for (int i = x; i < height; i++) {
            for (int j = y; j < width; j++) {
                iFreeSpace[i][j] = 1;
            }
        }

    }

    private boolean isPositionFree(int x, int y, int height, int width) {
        for (int i = x; i < height; i++) {
            for (int j = y; j < width; j++) {
                if (iFreeSpace[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    void seeArray() {
        for (int i = 0; i < iFreeSpace.length; i += 100) {
            for (int j = 0; j < iFreeSpace.length; j += 100) {
                if(iFreeSpace[i][j]==0){
                    System.out.print(" - ");
                }
                else {
                    System.out.print(" + ");
                }
            }
            System.out.println();
        }
    }


}
