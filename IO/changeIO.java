import java.io.*;

public class changeIO {
    public static void main(String[] args) throws IOException {
        FileInputStream in1=new FileInputStream("test01.txt");      //先用字节流读取
        InputStreamReader change=new InputStreamReader(in1);        //把字节流给转换流
        BufferedReader in2=new BufferedReader(change);      //再用转换流转成字符流
        //这样就可可以用字节流读取内容但是不是乱码了

        String a;
        while((a=in2.readLine())!=null){
            System.out.println(a);
        }
        in2.close();
        change.close();
        in1.close();
    }
}
