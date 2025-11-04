public class Test {
    public static void main(String[] args) {
//        Dog dog=new Dog(12,"black");
//        Cat cat=new Cat(55,"white");
//        Person laowang=new Person("LaoWang",55);
//
//        dog.eat("骨头");
//        dog.kanmen();
//        cat.catchMouse();
//        cat.eat("鱼");
//
//        laowang.keepDog(dog,"骨头");
//        laowang.keepCat(cat,"鱼鱼");
        //以上为非多态写法
        //有了多态的KeepPet后可以写成：
        Dog dog=new Dog(12,"black");
        Cat cat=new Cat(55,"white");
        Person laowang=new Person("LaoWang",55);
//        Animal cat1 = cat;
//        Animal dog1=dog;  //相当与默认做了这两句转换
        laowang.keepPet(cat,"yu");
        laowang.keepPet(dog,"gutou");
    }
}
