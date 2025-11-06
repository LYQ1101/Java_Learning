import java.util.*;

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


        //双列集合
        Map<Integer,String> m=new HashMap<>();

        m.put(1,"a");
        m.put(2,"b");
        m.put(3,"c");
        m.remove(3);
        //。。。还有很多的方法，不再赘述

        //遍历方法1
        for(Map.Entry<Integer,String> temp :m.entrySet())
        {
            Integer key=temp.getKey();
            String value=temp.getValue();
            System.out.printf(key+""+value);
        }
        //遍历方法2
        for(Integer key : m.keySet())
        {
            String value=m.get(key);
            System.out.printf(value);
        }
    }
}
