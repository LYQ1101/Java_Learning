import java.lang.reflect.Array;
import java.util.ArrayList;

public class Student {
    String name;
    int age;

    public Student(){}

    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }

    //方法引用的形参要和抽象方法的形参一致，所以会调用这个构造
    public Student(String a)
    {
        String[] arr=a.split(",");
        this.name=arr[0];
        this.age=Integer.parseInt(arr[1]);
    }

    //想要System.out.print打印自定义类就得重写toString 返回String
    @Override
    public String toString(){
        return this.name+this.age+" ";
    }

    public String getName(){
        return this.name;
    }
}
