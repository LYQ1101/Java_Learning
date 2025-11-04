public class ArrayUtil {
    ArrayUtil(){}   //一般来说这里要写成私有的，这里为了测试非静态方法调用


    public void printTest(ArrayUtil this)   //这个ArrayUtil this是虚拟机默认有的，相当于传入在外部调用这个方法的对象的地址，不写也没问题
    {
        System.out.printf("\n这是非静态方法的调用");
    }

    public static String printArr(int[] arr)    //这里对比的就是，静态方法是没有这个this的（默认即没有）
    {
        String total="[";
        for (int i = 0; i < arr.length; i++) {
            total+=Integer.toString(arr[i]);
        }
        total+=']';
        
        return total;

    }

    public static float getAverage(float []arr)
    {
        float sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
        }
        return sum/arr.length;
    }



}
