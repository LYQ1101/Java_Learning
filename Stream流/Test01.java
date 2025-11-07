import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.Collectors;

public class Test01{
    public static void main(String[] args) {
        //test1
        ArrayList<Float>list= new ArrayList<>();
        Collections.addAll(list,1F,2F,3F,4F,5F,6F,7F);
        list.stream().filter(s->s%2==0).forEach(s-> System.out.print(s+" "));

        System.out.printf("\n");
        //test2
        ArrayList<String> list2=new ArrayList<>();
        Collections.addAll(list2,"zhangsan,23","lisi,24","wangwu,25");
        Map<String,Integer> newset= list2.stream()
                .filter(s->Integer.parseInt(s.substring(s.length()-2))>23)
                .collect(Collectors.toMap
                                (s->s.split(",")[0], s->Integer.parseInt(s.split(",")[1]))
                );
        System.out.print(newset);
    }
}