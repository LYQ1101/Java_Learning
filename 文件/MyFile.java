import java.io.File;
import java.io.IOException;

public class MyFile {
    public static void main(String[] args) throws IOException {
        File file=new File("mhyfile\\aaa");

        file.mkdirs();

        File src=new File(file,"1.txt");

        src.createNewFile();
    }




}
