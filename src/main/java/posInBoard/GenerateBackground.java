package posInBoard;

import me.xdrop.jrand.JRand;

public class GenerateBackground {
    private CorePosition corePosition = new CorePosition();

    public void doIt(){
        while (corePosition.isFreeSpace()) {
            switch (JRand.natural().min(1).max(3).gen()) {
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
            //corePosition.seeArray();

        }


    }

}