public class Dog extends Animals implements Eat {
    @Override
    public void method()
    {
        System.out.printf("这是狗类中的方法调用\n");
    }

    @Override
    public void have()
    {
        System.out.printf("这是狗类中的接口吃调用\n");
    }
}
