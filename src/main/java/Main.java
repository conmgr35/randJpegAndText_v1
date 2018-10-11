import me.xdrop.jrand.JRand;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static int sizeImgArray = 37;
    static BufferedImage[] bufferedImages = new BufferedImage[sizeImgArray];

    static {
        for (int i = 0; i < bufferedImages.length; i++) {
            try {
                bufferedImages[i] = ImageIO.read(new File("res\\input\\" + (i + 1) + ".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        ReadTextFile readTextFile = new ReadTextFile();
        Main mainn = new Main();


        String[] type = readTextFile.geType();
        String[] model = readTextFile.getModel();
        String[] path = readTextFile.getPath();

        for (int i = 0; i < type.length; i++) {
            type[i] = mainn.getSpace(type[i]);
            model[i] = mainn.getSpace(model[i]);
            System.out.println(i + "/" + type.length + "\t" + type[i] + "\t" + model[i]);
        }


        if ((type.length == model.length) && (type.length == path.length)) {
            for (int i = 0; i < type.length; i++) {
                service.submit(new CoreProgr(model[i], type[i], path[i]));
            }
        }

        service.shutdown();
        System.out.println("END");


    }

    public String getSpace(String str) {
        char[] chr = new char[str.length() * 2];
        CharList charList = new CharList(str);
//        char[] inputString = str.toCharArray();
        for (int i = 0; i < chr.length; i = i + 2) {
            chr[i] = charList.getCharOfArray();
            chr[i + 1] = '\u200A';
        }
        return new String(chr);
    }

    class CharList {
        char[] array;
        int i;

        public CharList(String str) {
            this.array = str.toCharArray();
            this.i = 0;
        }

        public char getCharOfArray() {
            char ch = array[i];
            i++;
            return ch;
        }
    }

}

