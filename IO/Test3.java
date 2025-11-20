import java.io.*;

//缓冲流，接收的参数是FileInputStream
public class Test3 {
    public static void main(String[] args) throws IOException {
        //字节缓冲流----------------------
        //单个拷贝方法
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("test01.txt"));
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("copy2.txt"));

        int len;
        while ((len=in.read())!=-1){
            out.write(len);
        }

        in.close();
        out.close();

        //多个拷贝方法（数组）
        BufferedInputStream in1=new BufferedInputStream(new FileInputStream("test02.txt"));
        BufferedOutputStream out1=new BufferedOutputStream(new FileOutputStream("copy4.txt"));

        byte[]a =new byte[1024];
        int len1;
        while ((len1=in1.read(a))!=-1){
            out1.write(a,0,len1);
        }

        in1.close();
        out1.close();


        //字符缓冲流-------------------
        BufferedReader in2=new BufferedReader(new FileReader("test02.txt"));    //对应的是字符流的写法
        BufferedWriter out2=new BufferedWriter(new FileWriter("copy5.txt"));
        String line;
        while ((line=in2.readLine())!=null){
            out2.write(line);
            out2.newLine(); //跨平台的换行
        }
        out2.close();
        in2.close();    //缓冲流要写入文件一定得关闭，不然数据就在缓冲区

        BufferedWriter a1=new BufferedWriter(new FileWriter("test02.txt"));
        a1.write("请问你是谁");  //此步骤只是写入缓冲区，要写入文件一定要关闭！！！

        a1.close(); //关键！！！


    }
}
