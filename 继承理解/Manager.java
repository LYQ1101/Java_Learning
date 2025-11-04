public class Manager extends YuanGong{
    //共有的id,name,gongzi直接继承父类
    int guanli;
    //子类的所有构造方法会先走父类的无参构造
    public Manager(){}  
    public Manager(int id,String name,int gongzi,int guanli)
    {
        super(id,name,gongzi);
        //super解释：把收到的 3 个参数原封不动地“转手”交给父类构造器
        //让父类去完成
        //this.id = id; this.name = name; this.gongzi = gongzi; 这三句初始化
        //因为子类无法继承父类的构造方法，只能通过这种方式调用
        this.guanli=guanli;
    }

    public int getGuanli()
    {
        return guanli;
    }

    @Override   //重写父类中的方法
    public void gongZuo()
    {
        System.out.printf("我在做经理工作\n");
    }

    @Override
    public void shengHuo()
    {
        System.out.printf("我在做经理生活\n");
    }

}
