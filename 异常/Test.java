public class Test {
    public static void main(String[] args) {
        int[]arr={1,2,3};
        try {
            System.out.print(arr[4]);
        }
        catch (ArrayIndexOutOfBoundsException e)//数组索引越界类
        {
            System.out.printf("数组索引越界了\n");
        }
        System.out.printf("检测是否走到这一步");
    }
}
