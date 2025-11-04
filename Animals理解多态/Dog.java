public class Dog extends Animal {
    public Dog() {
    }
    public Dog(int age,String color)
    {
        super(age,color);
    }

    @Override
    void eat(String something)
    {
        System.out.printf("狗在吃%s\n",something);
    }

    public void kanmen()
    {
        System.out.printf("狗在看门\n");
    }
}
