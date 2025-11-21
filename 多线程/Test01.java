public class Test01 {
    public static void main(String[] args) {
        MyThread thread1=new MyThread();
        MyThread thread2=new MyThread();
        //如果用t1.run()方法就是直接调用方法了，和以前一样
        //用.start()才是标准的开启线程

        //两个线程是交替运行的
        thread1.setName("1");
        thread2.setName("2");
        thread1.start();
        thread2.start();
    }
}
