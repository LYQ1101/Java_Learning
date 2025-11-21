import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test03 {
    public static void main(String[] args) throws Exception {
        MyCallable call=new MyCallable();

        // 这里使用 Executors.newFixedThreadPool(1) 创建一个固定大小为1的线程池作为示例
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future=executor.submit(call);
        String result=future.get();
        executor.shutdown();

        //或者这样写
        FutureTask<String> future2=new FutureTask<String>(call);
        Thread th1=new Thread(future2); //创建进程来接收
        th1.start();    //此时就能用start

        String s1=call.call();  //注意，如果这样写就不是标准的启动线程方法
                                //和.start()不一样，.run()就是一个简单的方法
        System.out.println(s1);
    }
}
