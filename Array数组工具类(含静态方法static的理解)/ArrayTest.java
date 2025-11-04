public class ArrayTest {
    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        float[] array2={1.2F,5.5F,6.5F,9.6F,55F};

        String result=ArrayUtil.printArr(array);    //调用静态方法时就不用再new了
        float average=ArrayUtil.getAverage(array2);
        System.out.println(result);
        System.out.print(average);

        ArrayUtil a=new ArrayUtil();
        a.printTest();
    }
    //静态方法补充：
    //静态方法无 this
    //静态方法只能访问静态内容，无法访问非静态的成员内容  静态方法无 this.
    //非静态方法可以访问所有，因为非静态方法在调用的时候前面相当于都有一个 this. 只是省略了没写出来
    //静态方法无法访问实例变量，就是说静态方法里不能“直接”使用“还没有被 new 出来的”实例变量——因为静态方法在执行时可能一个对象都没建，而实例变量必须挂靠在某个具体对象上才能存在。

}
