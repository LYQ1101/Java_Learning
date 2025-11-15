import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws IOException {

        //单字符接收
        FileReader fil=new FileReader("test01.txt");
        int tem ;
        while((tem=fil.read())!=-1){    //空参read返回的是字符本身
            System.out.print((char)tem);
        }

        System.out.printf("\n");
        //数组接收
        FileReader fil2=new FileReader("test01.txt");
        char []a=new char[2];   //数组长度2，两个两个长度读取
        int m;
        while ((m= fil2.read(a))!=-1){   //带参read返回的是这次读取的字符长度（读取了几个字符），每次调用read时候，传入的a都被付给写入2字符
            System.out.print(new String(a,0,m));
        }

        fil.close();
    }
}
