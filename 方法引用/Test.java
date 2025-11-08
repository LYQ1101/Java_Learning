import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<String>list=new ArrayList<>();
        ArrayList<String>list2=new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        Collections.addAll(list2,"a","b","c","d","e");
        //静态方法引用，把其中的元素都变成int
        list.stream().map(Integer::parseInt).forEach(s->System.out.print(s+" "));

        //如果是特定对象的成员方法引用，如下输出时
        list.stream().map(Integer::parseInt).forEach(System.out::print);
        System.out.printf("\n");
        //任意对象的成员方法引用
        list2.stream().map(String::toUpperCase).forEach(System.out::print);
    }
}
