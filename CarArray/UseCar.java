public class UseCar {
    public static void main(String[] args)
    {
        Car[] car=new Car[3];
        for(int i=0;i<3;i++)
        {
            Car c=new Car();
            car[i]=c;
        }
        for(int i=0;i<3;i++)
        {
            System.out.println(car[i]);
        }
    }

}
