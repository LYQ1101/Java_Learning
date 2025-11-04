public class Test {
    public static void main(String[] args) {
        YuanGong yuan=new YuanGong(1,"你好",1221);
        Manager jingli=new Manager(2,"打野",55555,74454151);
        Manager jingli2=new Manager();

        System.out.printf("%d\n",yuan.getId());
        yuan.gongZuo();
        yuan.shengHuo();;

        System.out.printf("%d\n",jingli.getId());   //继承了父类方法，可以直接调用
        jingli.gongZuo();
        jingli.shengHuo();

        //走默认构造的子类
        System.out.printf("%d\n",jingli2.getId());   //子类的无参构造也先走父类，因此赋值为0
        jingli.gongZuo();
        jingli.shengHuo();
    }
}
