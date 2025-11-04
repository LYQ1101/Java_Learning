public class Person {
    String name;
    int age;
    public Person(){}
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

//    public void keepDog(Dog dog, String food)
//    {
//        System.out.printf("年龄为%d饲养员%s正在喂养狗%s\n",this.age,this.name,food);
//        dog.eat(food);
//    }
//    public void keepCat(Cat cat,String food)
//    {
//        System.out.printf("年龄为%d饲养员%s正在喂养猫%s\n",this.age,this.name,food);
//        cat.eat(food);
//    }
    //以上为非多态写法
    public void keepPet(Animal animal,String food)
    {
        System.out.printf("年龄为%d饲养员%s正在喂养动物%s\n",this.age,this.name,food);
        animal.eat(food);
        //animal.kanmen()  这种子类中独特的方法就无法调用
    }

}
