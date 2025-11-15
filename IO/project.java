import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class project {
    public static void main(String[] args) throws IOException {
        FileInputStream in=new FileInputStream("test01.txt");
        FileOutputStream out=new FileOutputStream("jiami_test01.txt");

        int len;
        byte [] bytes=new byte[1024];
        int m;
        int i=0;
        while ((m=in.read())!=-1){
            out.write(m^i);
            i+=1;
        }
        System.out.printf("加密完成\n");
        in.close();
        out.close();

        //解密过程
        int jiemi;
        int j=0;
        FileInputStream in2=new FileInputStream("jiami_test01.txt");
        FileOutputStream out2=new FileOutputStream("jiami_test01.txt");
        while((jiemi=in2.read())!=-1){
            out2.write((char)jiemi^j);
            j+=1;
        }
        System.out.printf("解密完成");
        in2.close();
        out2.close();



    }
}
