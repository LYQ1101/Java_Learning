public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (MyRun.class) {
                System.out.printf("这是" + i + "\n");
            }
        }

    }
}
