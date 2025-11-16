import java.io.Serializable;

public class Student implements Serializable {
    String name;
    int age;

    public Student(String name, int i) {
        this.name=name;
        this.age=age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                '}';
    }
}
