import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LearnStream {
    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<>();
        Collections.addAll(list,"张三","李四","王五","张一一","接收","你好");

        //中间方法、链式编程、lambda
        list.stream().filter(s -> s.startsWith("张")).filter(s->s.length()==3).forEach(s-> System.out.print(s+" "));
        System.out.print("\n");
        list.stream().limit(4).skip(2).forEach(s-> System.out.print(s+" "));

        //终结方法 foreach()等
        //例如
        //匿名内部类写法
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });
        //lambda表达式写法
        list.stream().forEach(s-> System.out.print(s));
        System.out.printf("\n");

        List<String> newlist=list.stream()
                .filter(s->s.startsWith("张"))
                .collect(Collectors.toList());
        newlist.stream().forEach(s-> System.out.print(s+" "));
    }
}
