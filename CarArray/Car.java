public class Car {
    String pingpai;
    int value;
    String color;

    public Car()
    {
        //默认构造
        this.pingpai="杂牌";
        this.color="黑色";
        this.value=150000;
    }
    public Car(String pingpai,int value,String color)
    {
        this.pingpai=pingpai;
        this.value=value;
        this.color=color;
    }

    public void setPingpai(String pingpai)
    {
        this.pingpai=pingpai;
    }

    public String getPingpai()
    {
        return this.pingpai;
    }

    public void setColor(String color)
    {
        this.color=color;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setValue(int value)
    {
        this.value=value;
    }

    public int getValue()
    {
        return this.value;
    }
}

