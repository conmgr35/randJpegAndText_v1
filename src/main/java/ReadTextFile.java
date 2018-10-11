import java.io.*;
import java.util.List;
import org.apache.commons.io.FileUtils;


public class ReadTextFile {

    public ReadTextFile() {
    }

    public String[] getModel(){
        return getStringArray("res/Model.txt");
    }
    public String[] geType(){
        return getStringArray("res/Type.txt");
    }
    public String[] getPath(){
        return getStringArray("res/Path.txt");
    }

    private String[] getStringArray(String filename){
        List<String> lines = null;

        try {
            lines = FileUtils.readLines(new File(filename), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
    }

}
