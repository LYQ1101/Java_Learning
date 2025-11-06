import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class learnCollection {
    public static void main(String[] args) {
//        Collection<Student> stu=new ArrayList<>();
//        stu.add(new Student("a",12));
//        stu.add(new Student("c",13));
//        stu.add(new Student("e",44));
//        stu.add(new Student("2",123));
//
//        Student tem=new Student("e",44);
//        System.out.println(stu.contains(tem));  //此处为地址判断
//
//        System.out.println(stu.isEmpty());
//        System.out.print(stu.size());

        Collection<String> coo=new ArrayList<>();
        coo.add("aaa");
        coo.add("bbb");
        coo.add("ccc");

        Iterator<String> it=coo.iterator(); //迭代器遍历
        while(it.hasNext())
        {
            String st=it.next();
            System.out.printf(st);
        }

        for(String s : coo){    //增强for遍历
            System.out.printf(s);
        }
    }
}
