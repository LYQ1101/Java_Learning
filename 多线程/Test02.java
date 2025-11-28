public class Test02 {
    public static void main(String[] args) {
        MyRun run1=new MyRun();

        Thread t1=new Thread(run1);
        Thread t2=new Thread(run1);

        t1.start();
        t2.start();
    }
}
