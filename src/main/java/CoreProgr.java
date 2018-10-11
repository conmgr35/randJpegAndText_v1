import javax.imageio.ImageIO;
import javax.management.Attribute;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CoreProgr implements Runnable {
    private String type;
    private String model;
    private String path;

    public CoreProgr() {
    }

    public CoreProgr(String type, String model, String path) {
        this.type = type;
        this.model = model;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            firstMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void firstMethod() throws IOException {

//        BufferedImage bufferedImage = ImageIO.read(new File("res/fone/1.jpg"));
        BufferedImage bufferedImage = new BufferedImage(1000, 1000, 1);
//        int w = bufferedImage.getWidth();

        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();

        setFourJpegInGraphics(graphics);

        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        if ((this.type.length() + this.model.length()) < 30) {
            graphics.fillRect(0, 0, 1000, 200);
        } else {
            graphics.fillRect(0, 0, 1000, 145);
        }
        graphics.fillRect(0, 800, 1000, 200);

        graphics.setColor(Color.WHITE);

        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.73f));
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int curentFontSize = 84;        // <-  розмір шрифта міняти тут

        Font font = new Font("Arial Bold", Font.ROMAN_BASELINE, curentFontSize);

        graphics.setFont(font);
        FontMetrics metrics = graphics.getFontMetrics(font);
        String metStr = " \t" + metrics.stringWidth(model) + " \t" + metrics.stringWidth(type);
        Font fontModel = new Font("Arial Bold", Font.ROMAN_BASELINE, curentFontSize),
                fontType = new Font("Arial Bold", Font.ROMAN_BASELINE, curentFontSize);


//        if ((metrics.stringWidth(model) > 950) || (metrics.stringWidth(type) > 950)) {
//            int maxSize = (metrics.stringWidth(model) > metrics.stringWidth(type)) ? metrics.stringWidth(model) : metrics.stringWidth(type);
//            font = new Font("Arial Bold", Font.ROMAN_BASELINE, (int) ((950 * curentFontSize) / maxSize));
//        }
        if ((metrics.stringWidth(model) > 950)) {
            fontModel = new Font("Arial Bold", Font.ROMAN_BASELINE, (int) ((950 * curentFontSize) / metrics.stringWidth(model)));
        }

        if ((metrics.stringWidth(type) > 950)) {
            fontType = new Font("Arial Bold", Font.ROMAN_BASELINE, (int) ((950 * curentFontSize) / metrics.stringWidth(type)));
        }


//        if ((metrics.stringWidth(model) > 900) || (metrics.stringWidth(type) > 900)) {
//            if ((metrics.stringWidth(model) > 1000) || (metrics.stringWidth(type) > 1000)) {
//                if ((metrics.stringWidth(model) > 1050) || (metrics.stringWidth(type) > 1050)) {
//                    if ((metrics.stringWidth(model) > 1200) || (metrics.stringWidth(type) > 1200)) {
//                        if ((metrics.stringWidth(model) > 1300) || (metrics.stringWidth(type) > 1300)) {
//                            font = new Font("Arial Bold", Font.ROMAN_BASELINE, 55);
//                        } else {
//                            font = new Font("Arial Bold", Font.ROMAN_BASELINE, 61);
//                        }
//                    } else {
//                        font = new Font("Arial Bold", Font.ROMAN_BASELINE, 76);
//                    }
//                } else {
//                    font = new Font("Arial Bold", Font.ROMAN_BASELINE, 78);
//                }
//            } else {
//                font = new Font("Arial Bold", Font.ROMAN_BASELINE, 82);
//            }
        graphics.setFont(font);
//        }

        metrics = graphics.getFontMetrics(font);
        if ((this.type.length() + this.model.length()) < 30) {

            graphics.fillRect(0, 200, 1000, 600);
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            graphics.setColor(Color.decode("#000000"));
            graphics.drawString(model + " " + type, (int) ((bufferedImage.getWidth() - metrics.stringWidth(model) - metrics.stringWidth(type)) / 2), 321);

        } else {

            graphics.fillRect(0, 145, 1000, 655);
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

            graphics.setColor(Color.decode("#000000"));

            FontMetrics metricsFontModel = graphics.getFontMetrics(fontModel);
            graphics.setFont(fontModel);
            graphics.drawString(model, (int) ((bufferedImage.getWidth() - metricsFontModel.stringWidth(model)) / 2), 227);


            FontMetrics metricsFontType = graphics.getFontMetrics(fontType);
            graphics.setFont(fontType);
            graphics.drawString(type, (int) ((bufferedImage.getWidth() - metricsFontType.stringWidth(type)) / 2), 321);
        }

        graphics.setFont(font);
        graphics.setColor(new Color(148, 2, 2).brighter());
        graphics.drawString(" Е с т ь   в   н а л и ч и и", (int) ((bufferedImage.getWidth() - metrics.stringWidth("Е с т ь   в   н а л и ч и и")) / 2), 435);

        graphics.setColor(Color.decode("#000000"));
        graphics.drawString("н а   н а ш е м   с к л а д е .", (int) ((bufferedImage.getWidth() - metrics.stringWidth("н а   н а ш е м   с к л а д е .")) / 2), 532);
        graphics.drawString("Ф о т о г р а ф и и   с к о р о ", (int) ((bufferedImage.getWidth() - metrics.stringWidth("Ф о т о г р а ф и и   с к о р о")) / 2), 636);
        graphics.drawString(" б у д у т   н а   э т о м   с а й т е.", (int) ((bufferedImage.getWidth() - metrics.stringWidth("б у д у т   н а   э т о м   с а й т е .")) / 2), 741);


        ImageIO.write(bufferedImage, "jpg", new File("outImages\\" + path));

        System.out.println("Image Created \t" + type + "\t" + path + metStr);
    }

    private void setFourJpegInGraphics(Graphics2D graphics) {

        Image[] images = getAllJpeg();
        AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
        graphics.setComposite(alphaChannel);

        for (int i = 0, x = 0; x <= 800; x += 200) {
            for (int y = 0; y <= 800; y += 200, i++) {
                graphics.drawImage(images[i], x, y, 200, 200, null);
            }

        }

//        graphics.drawImage(images[0], 0, 0, 200, 200, null);
//        graphics.drawImage(images[1], 200, 0, 200, 200, null);
//        graphics.drawImage(images[2], 400, 0, 200, 200, null);
//        graphics.drawImage(images[3], 600, 0, 200, 200, null);
//        graphics.drawImage(images[4], 800, 0, 200, 200, null);
//
//        graphics.drawImage(images[5], 0, 200, 200, 200, null);
//        graphics.drawImage(images[6], 200, 200, 200, 200, null);
//        graphics.drawImage(images[7], 400, 200, 200, 200, null);
//        graphics.drawImage(images[8], 600, 200, 200, 200, null);
//        graphics.drawImage(images[9], 800, 200, 200, 200, null);
//
//        graphics.drawImage(images[10], 0, 400, 200, 200, null);
//        graphics.drawImage(images[11], 200, 400, 200, 200, null);
//        graphics.drawImage(images[12], 400, 400, 200, 200, null);
//        graphics.drawImage(images[13], 600, 400, 200, 200, null);
//        graphics.drawImage(images[14], 800, 400, 200, 200, null);
//
//        graphics.drawImage(images[15], 0, 600, 200, 200, null);
//        graphics.drawImage(images[16], 200, 600, 200, 200, null);
//        graphics.drawImage(images[17], 400, 600, 200, 200, null);
//        graphics.drawImage(images[18], 600, 600, 200, 200, null);
//        graphics.drawImage(images[19], 800, 600, 200, 200, null);
//
//        graphics.drawImage(images[20], 0, 800, 200, 200, null);
//        graphics.drawImage(images[21], 200, 800, 200, 200, null);
//        graphics.drawImage(images[22], 400, 800, 200, 200, null);
//        graphics.drawImage(images[23], 600, 800, 200, 200, null);
//        graphics.drawImage(images[24], 800, 800, 200, 200, null);

    }

    private Image[] getAllJpeg() {
        Image[] imagesArray = new Image[25];

        MyRandomArray myRandomArray = new MyRandomArray();
        int[] randomInteger = myRandomArray.getArray();
//        ArrayList<Integer> ran-17^50 domInteger = myRandomArray.getArray();

        for (int i = 0; i < imagesArray.length; i++) {
            try {
//                imagesArray[i] = ImageIO.read(new File("res\\input\\" + randomInteger[i] + ".jpg"));
                imagesArray[i] = Main.bufferedImages[randomInteger[i] - 1];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imagesArray;
    }

}
