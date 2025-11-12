import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream input=new FileInputStream("C:\\Users\\lyq\\Desktop\\Apifox.lnk");
        FileOutputStream output=new FileOutputStream("copy.lnk");
        int b;
        while((b=input.read())!=-1){
            output.write((char)b);
        }
        input.close();
        output.close();
    }
}
