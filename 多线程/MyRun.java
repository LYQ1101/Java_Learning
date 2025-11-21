public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 22; i++) {
            System.out.printf("这是runnable的线程\n");
        }

    }
}
