import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"林,1","张三,22","急啊家的,21","李四,55");
        //把集合的元素转换为学生类并加入到一个数组中
        Student[]stu= list.stream().map(Student::new).toArray(Student[]::new);
        Arrays.stream(stu).sequential().forEach(System.out::print);

        String[]stu_name=list.stream()
                .map(Student::new)
                .map(Student::getName).toArray(String[]::new);
                //此处map中getName得到的是一堆String的，所以toArray要转成String类型的数组，接收那也要该
        Arrays.stream(stu_name).forEach(System.out::print);
    }
}
