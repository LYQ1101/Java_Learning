public class Cat extends Animal{
    public Cat() {
    }
    public Cat(int age,String color)
    {
        super(age,color);
    }

    @Override
        void eat(String something)
        {
            System.out.printf("猫在吃%s\n",something);
        }

        public void catchMouse()
        {
            System.out.printf("猫在抓老鼠\n");
        }

}
