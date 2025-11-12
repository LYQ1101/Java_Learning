import java.io.File;
import java.io.IOException;

public class MyFile {
    public static void main(String[] args) throws IOException {
        File file=new File("mhyfile/bbb");

        boolean a=file.mkdir();
        System.out.print(a);

        File src=new File(file,"1.txt");

//        file.createNewFile();
    }




}
