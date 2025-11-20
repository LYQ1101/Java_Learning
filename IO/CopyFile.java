import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
//        FileInputStream input=new FileInputStream("C:\\Users\\lyq\\Desktop\\Apifox.lnk");
//        FileOutputStream output=new FileOutputStream("copy.lnk");
//        FileOutputStream output2=new FileOutputStream("copy2.lnk");
//        int b;
//        while((b=input.read())!=-1){
//            output.write((char)b);
//        }
//
//        //copy方法2   从一个一个字节搬运到用一块一块字节装进数组一次一次搬运。
//        int len;
//        byte[] bytes=new byte[1024*1024*5];
//        while((len=input.read(bytes))!=-1){
//            output2.write(bytes,0,len);
//        }
//        input.close();
//        output.close();

        //带子文件夹的copy
        File source=new File("test");
        if (!source.exists() || !source.isDirectory()) {
            System.out.println("源文件夹不存在！");
            return;
        }
        File order=new File("C:\\Users\\lyq\\Desktop\\copy");
        copyfile(source,order);
    }

    private static void copyfile(File source, File order) throws IOException {
        order.mkdir();

        File []files=source.listFiles();
        for(File file : files){
            if(file.isFile()){
                FileInputStream in=new FileInputStream(file);
                FileOutputStream out=new FileOutputStream(new File(order,file.getName()));
                byte []bytes=new byte[1024];
                int len;
                while ((len=in.read(bytes))!=-1){
                    out.write(bytes,0,len);
                }
                out.close();
                in.close();
            }
            else {
                copyfile(file,new File(order,file.getName()));
            }
        }
    }
}
