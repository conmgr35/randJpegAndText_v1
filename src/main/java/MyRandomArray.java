import me.xdrop.jrand.JRand;

import java.util.ArrayList;
import java.util.Random;

public class MyRandomArray {

    int[] arr = new int[Main.sizeImgArray];

    {
        for (int i = 0; i < Main.sizeImgArray; i++) {
            arr[i] = i + 1;
        }
    }

    public int[] getArray() {
        int[] rndmArray = new int[25];
//        ArrayList<Integer> rndmArray = new ArrayList<>();
        for (int i = 0, maxArraySize = arr.length - 1; i < rndmArray.length; i++, maxArraySize--) {
            int randNumb = JRand.natural().min(0).max(maxArraySize).gen();
            rndmArray[i] = (arr[randNumb]);
            arr[randNumb] = arr[maxArraySize];
        }

//        boolean isRun = true;
//        while (isRun) {
////            Random r = new Random();
////            isRun = isNumberTrue(rndmArray, r.nextInt(32) + 1); // задаємо діапазон
//            isRun = isNumberTrue(rndmArray, JRand.natural().min(1).max(32).gen());
//        }
        return rndmArray;
    }

//    public boolean isNumberTrue(ArrayList<Integer> array, int i) {
//        Boolean isNumberInArray = false;
//        for (int numb : array) {
//            if (numb == i)
//                isNumberInArray = true;
//        }
//        if (isNumberInArray == false)
//            array.add(i);
//        return array.size() >= 25 ? false : true;  //4 задаємо скільки має бути унікальних чисел
//    }

}
