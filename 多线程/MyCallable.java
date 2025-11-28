import java.util.concurrent.Callable;

//这是个泛型的接口调用
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.printf("这是Callable方式的调用\n");
        return "这是它的返回值，可以用对应类型接收";
    }
}
