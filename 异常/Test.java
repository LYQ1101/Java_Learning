public class Test {
    public static void main(String[] args) {
        int[]arr={};
        try {
            System.out.print(arr[4]);
        }
        catch (ArrayIndexOutOfBoundsException e)//数组索引越界类
        {
//            System.out.printf("数组索引越界了\n");
            e.printStackTrace();
        }
        System.out.printf("检测是否走到这一步\n");

        //抛出异常
        int one=getOne(arr);
        System.out.print(one);
    }

    public static int getOne(int[] arr) throws NegativeArraySizeException,NullPointerException
    {
        if(arr==null)
            //手动创建一个异常对象，并把这个异常方法交给调用者处理，后面的代码不会再执行了
            throw new RuntimeException();
        return arr[0];
    }
}
