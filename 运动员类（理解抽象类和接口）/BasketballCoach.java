public class BasketballCoach extends Coach implements run{
    @Override
    public void teach()
    {
        System.out.printf("篮球教练在教人");
    }

    @Override
    public void running()
    {
        System.out.printf("篮球教练跑步");
    }
}
