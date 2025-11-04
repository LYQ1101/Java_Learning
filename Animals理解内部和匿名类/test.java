public class test {
    public static void main(String[] args) {
        //按照以往的写法，调用dog和接口要新建对象
        Dog dog=new Dog();
        dog.method();
        dog.have();
        //这样每次调用方法时都要新建一个类，有点浪费

        //以下为使用匿名内部类的写法：
        //创建了一个临时的、没有名字的类，并且立即实例化这个对象
        Animals dog3=new Dog()
        {
            @Override
            public void method()
            {
                System.out.printf("这是调用匿名内部类的写法\n");
            }
        };
        Eat eat1=new Eat()
        {
            @Override
            public void have()
            {
                System.out.printf("这是匿名内部类的接口\n");
            }
        };
        dog3.method();
        eat1.have();

        new Dog()
        {
            @Override
            public void method()
            {
                System.out.printf("这是匿名内部类");
            }
        }.method();
    }
}
