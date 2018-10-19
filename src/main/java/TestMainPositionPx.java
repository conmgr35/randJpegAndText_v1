import me.xdrop.jrand.JRand;
import posInBoard.CorePosition;

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


        System.out.println("___________________________________________");
        corePosition.seeArray();
        System.out.println("___________________________________________");
        corePosition.seeBlockArray();

    }


}

