import java.util.*;

public class Poker {

    static ArrayList<String> list=new ArrayList<>();   //初始化牌盒
    static HashMap<String,Integer> jiazhi=new HashMap<>();  //用来转换牌的价值
    //准备牌（初始化）
    static  //静态代码块，外部类创建该类时调用
    {
        String color[]={"♣","♠","♥","♦"};
        String number[]={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        for(String c :color)
        {
            for(String n:number)
            {
                list.add(c+n);
            }
        }
        //添加大小王
        list.add("joker");
        list.add("Joker");

        //添加价值转换集合键对
        jiazhi.put("A",14);
        jiazhi.put("2",15);
        jiazhi.put("J",11);
        jiazhi.put("Q",12);
        jiazhi.put("K",13);
    }

    public Poker(){
        //洗牌
        Collections.shuffle(list);
        //发牌
        //发牌要准备四组牌（三个玩家，一个地主,发牌时存储）
        ArrayList<String> dizhu=new ArrayList<>();
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String pai=list.get(i);
            if(i<3)
            {
                dizhu.add(pai);
                continue;
            }

            if(i%3==0)
            {
                player1.add(pai);
            } else if (i%3==1) {
                player2.add(pai);
            }
            else if(i%3==2){
                player3.add(pai);
            }

        }

        //排序
        order(player1);
        order(player2);
        order(player3);
        //看牌
        lookPoker("张三",player1);
        lookPoker("李四",player2);
        lookPoker("王五",player3);
        lookPoker("地主",dizhu);
    }

    //看牌
    public void lookPoker(String name,ArrayList<String> pokers) //传入玩家名字和对应的牌
    {
        System.out.print(name+"：");
//        for (String poker : pokers) {
//            System.out.print(poker);
//        }
        System.out.print(pokers);
        System.out.println();
    }

    //比较大小
    public void order(ArrayList<String > list)
    {
        Collections.sort(list, new Comparator<String>() {   //比较器用法
            @Override
            public int compare(String o1, String o2) {
                //String color1=o1.substring(0,1);  先不考虑花色排序
                int value1=getValue(o1);
                //String color2=o2.substring(0,1);
                int value2=getValue(o2);
                int i=value1-value2;    //升序排序，返回负数时候v1排在v2前面，反之后面
                return i==0?0:i;
            }
        });
    }

    //价值转换
    public int getValue(String pai)
    {
        if(pai=="Joker")
        {
            return 17;
        } else if (pai=="joker") {
            return 16;
        }
        String key=pai.substring(1);
        if(jiazhi.containsKey(key)) {
            return jiazhi.get(key);
        }
        else {
            return Integer.parseInt(key);
        }
    }

}
