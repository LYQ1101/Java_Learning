import java.io.*;

public class xuliehua {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu=new Student("张三",12);

        //序列化
        FileOutputStream ou=new FileOutputStream("test01.txt");
        ObjectOutputStream out=new ObjectOutputStream(ou);
        //反序列化
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("test01.txt"));

        out.writeObject(stu);
        Object ob=in.readObject();
        System.out.print(stu);

        out.close();
        in.close();

    }
}
