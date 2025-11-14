import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        FileInputStream input=new FileInputStream("C:\\Users\\lyq\\Desktop\\Apifox.lnk");
        FileOutputStream output=new FileOutputStream("copy.lnk");
        FileOutputStream output2=new FileOutputStream("copy2.lnk");
        int b;
        while((b=input.read())!=-1){
            output.write((char)b);
        }

        //copy方法2   从一个一个字节搬运到用一块一块字节装进数组一次一次搬运。
        int len;
        byte[] bytes=new byte[1024*1024*5];
        while((len=input.read(bytes))!=-1){
            output2.write(bytes,0,len);
        }
        input.close();
        output.close();
    }
}
