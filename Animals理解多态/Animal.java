public class Animal {
    int age;
    String color;
    public Animal ()
    {}
    public Animal(int age,String color)
    {
        this.age=age;
        this.color=color;
    }


    void eat(String something)
    {
        System.out.printf("动物在吃%s",something);
    }
}


