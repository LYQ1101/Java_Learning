public class Player
{
    String name;
    int hp;

    public Player()
    {
        name="张三";  //默认名字张三
        hp=100;     //默认血量100
    }

    public Player(String name,int hp)
    {
        this.name=name;
        this.hp=hp;
    }

	public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp()
    {
        return this.hp;
    }

    public void fighted(double shanghai)
    {
        hp-=shanghai;
    }

}