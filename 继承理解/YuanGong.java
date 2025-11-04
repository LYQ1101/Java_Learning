public class YuanGong {
    int id;
    String name;
    int gongzi;

    public YuanGong(){
        id=0;
        name="张三";
        gongzi=100;
    } //无参构造
    public YuanGong(int id,String name,int gongzi)  //有参构造
    {
        this.id=id;
        this.name=name;
        this.gongzi=gongzi;
    }

    public int getId()
    {
        return id;
    }

    public void gongZuo()
    {
        System.out.printf("我在工作\n");
    }
    public void shengHuo()
    {
        System.out.printf("我在吃饭\n");
    }
}
