import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo=new FileOutputStream("test01");
        fo.write(82);
        byte [] m={77,78,79,80};
        fo.write(m,1,2);

        FileInputStream input=new FileInputStream("test01");
        int b;
        while((b=input.read())!=-1){
            System.out.print((char)b+"\n");
        }
        fo.close();
    }
}
