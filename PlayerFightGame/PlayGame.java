import java.util.Scanner;

public class PlayGame
{
    public static void main(String[] args)
    {
        Player p1=new Player();
        Player p2=new Player();
        String name1,name2;
        int hp1,hp2;
        double shanghai;
        System.out.println("请输入玩家的名字和血量（p1,p2）");
        Scanner sc=new Scanner(System.in);
        name1=sc.nextLine();
        name2=sc.nextLine();
        hp1=sc.nextInt();
        hp2=sc.nextInt();
        p1.setName(name1);
        p1.setHp(hp1);
        p2.setName(name2);
        p2.setHp(hp2);
        System.out.println("您输入的名称和血量为：");
        System.out.println(p1.getName());
        System.out.print(p1.getHp());
        System.out.println(p2.getName());
        System.out.print(p2.getHp());
        while(p1.getHp()>0&&p2.getHp()>0)
        {
            shanghai=(Math.random()*10);
            p1.fighted(shanghai);
            shanghai=(Math.random()*10);
            p2.fighted(shanghai);
            System.out.println("\np1还剩下");
            System.out.print(p1.getHp());
            System.out.println("\np2还剩下");
            System.out.print(p2.getHp());
            if(p1.getHp()<=0)
            {
                System.out.println("\np1死了");
            }
            else if(p2.getHp()<=0)
            {
                System.out.println("\np2死了");
            }
        }
    }
}