# java学习速记

## 一、面向对象高级

### 1.静态 static

#### 详情例子可见Array数组工具类

#### a.静态方法无this，静态方法只能访问静态内容，无法访问非静态的成员内容。非静态方法都是有这个this的，只是传参的时候没写出来，所以可以访问所有成员内容。

#### b.静态方法无法访问实例变量，就是说静态方法里不能“直接”使用“还没有被 new 出来的”实例变量——因为静态方法在执行时可能一个对象都没建，而实例变量必须挂靠在某个具体对象上才能存在。如下：

```
class Demo {
    int  x = 10;          // 实例变量（对象级别）
    static int y = 20;    // 静态变量（类级别）

    static void foo() {
        // System.out.println(x);     // ❌ 编译错误：Non-static field 'x' cannot be referenced from a static context
        System.out.println(y);        // ✅ 可以，y 跟类绑定，不需要对象
    }
}
```

#### c.把工具类的方法写成静态的，在外部类调用的时候就不用new一个该工具类的对象，可以直接.方法名使用，相当于提供了一个更方便的“接口”。

### 

### 2.继承

#### a.关键字：extends

```继承语法示例
public class Student extends Person{}
```

#### b.继承可以避免多个相同功能的代码块重复（在创建类的时候），类与类之间存在相同共性的内容，就可以继承而来。

#### c.继承的继承权限：父类中：构造方法都不能；成员变量中public和private都可以（这个private的情况是有点特殊，不能直接用，是拷贝来的）；成员方法public可以，private不能；

#### d.继承的特点：只能单继承（一个类只有一个父类），不能多继承，但能多层继承（一条继承链上）。同时，java所有的类都直接或间接的继承于Object类。

#### d.继承中<u>变量/方法</u>调用的就近原则：优先级：局部-本类-父类。若变量/方法重名了，有几个关键字：this.直接调用本类，super.直接调用父类。

```调用变量示例
public class Person
{
    String name="1";
}
public class Xiaoming extends Person
{
    String name="2";
    void test()
    {
        String name="3";
        System.out.print(name);    //输出3
        System.out.print(this.name);    //输出2
        System.out.print(super.name);    //输出1
    }
}
```

#### e.方法的重写：当子类继承的方法无法满足子类要求时，就重写方法（命名和父类一样），注意：①关键字：@Override；②名称、形参和父类一致；③静态方法不能重写;

```重写示例
class Animal {
    // 动物会叫——但每种动物叫声不同
    void shout() {
        System.out.println("动物叫了一声");
    }
}

// 子类：猫
class Cat extends Animal {
    // 猫觉得父类叫得太笼统，自己重新实现
    @Override          // 写上@Override，编译器会帮你检查拼写错误
    void shout() {
        System.out.println("喵喵喵~");
    }
}

public class Demo {
    public static void main(String[] args) {
        Animal a = new Animal();  // 纯动物
        Animal c = new Cat();     // 猫被当成动物（向上转型）

        a.shout();  // 动物叫了一声
        c.shout();  // 喵喵喵~   （子类重写生效）
    }
}
```

#### f.构造方法的继承：①父类的构造方法不会被子类继承；②子类的所有构造方法默认先访问父类的无参构造，再执行自己的；③this关键字表示当前方法调用者的地址值；④super关键字表示父类存储空间；

### 3.多态

#### 使用父类作为一个方法的形参，使得该方法可以接收所有的子类，就是用统一的方法处理不同类型的对象。Fu fu=Zi zi;

#### a.多态的前提：①有继承/实现的关系；②有父类引用子类对象，相当于把一个子类对象赋值给父类；③有方法的重写（因为多态就是多个子类对象共用一个方法，要实现不同的功能那么每个子类里面都要有相关的重写）

#### c.多态中成员变量和成员方法的调用方法：例如有 Fu fu=Zi zi；①fu调用成员方法时： 编译时会看左边的Fu类有无这个方法，有则成功无则失败；运行时实际上运行的是Zi类的重写的该方法（子类无时去才调用父类）；②fu调用成员变量时，会看Fu类中有无这个变量，有则成功无则失败。运行的时候实际运行的也是Fu类中的变量。

#### d.正是因为c中提到的特征，多态命名的 Fu fu=Zi zi;中的fu无法调用其类中的特征方法（即子类独有的），只能调用父类里有的，且Zi类中重写过的方法。为了解决这个问题，可以把该对象转换为子类就行：Zi son=(Zi) zi;类似强制类型转换，还可以加一个instanceof判断。

### 4.包

#### a.包就是文件夹，用来管理各种不同功能的java类。

#### b.使用同一个包中的类，不需要导包。适合用java.lang包中的类，不需要导包，其余情况都要导包。同时使用不同包中同名类时，一定要用“包名.类名”。

### 5.final

#### a.修饰方法：最终方法，不能被重写

#### b.修饰类：最终类，不能被继承

#### c.修饰变量：是常量，不能被修改；基本数据类型：变量的值不能被修改；引用数据类型：内部的属性值可以修改。

### 6.抽象类 abstract

#### 不能创建对象，其子类要么重写抽象类中的所有方法，要么自己也是抽象类。强制子类方法必须按照某种格式重写，规范了项目。抽象方法只有方法名，没有方法体。

#### ### 核心思想：抽象方法的价值

当两个（或多个）子类：

1. **有共性：** 它们都属于同一个概念范畴（例如，都是 `Animal` 动物），并且都应该具备某种行为（例如，都会 `move()` 移动）。

2. **实现不同：** 它们执行该行为的具体方式却不一样（例如，`Bird` 飞行，`Fish` 游泳）。

在这种情况下，我们就可以：

1. 将这个共同的方法（如 `move()`）定义在它们的**抽象父类**中。

2. 将该方法声明为**抽象方法**（`public abstract void move();`）。
   
   #### 有了以上父类的抽象方法进行定义和规范后，子类只需在子类中重写该抽象方法就可以实现子类独特的功能同时又保证父类该方法的规范。
   
   ```
   // 抽象父类
   public abstract class Animal {
       // 抽象方法：所有动物都会移动，但移动方式不同，所以只做声明
       public abstract void move(); 
   
       // 普通方法：所有动物都有名字，实现是统一的
       public void eat() {
           System.out.println("Animal is eating.");
       }
   }
   
   // 子类 1
   public class Bird extends Animal {
       @Override
       public void move() {
           System.out.println("Bird is flying."); // 飞行
       }
   }
   
   // 子类 2
   public class Fish extends Animal {
       @Override
       public void move() {
           System.out.println("Fish is swimming."); // 游泳
       }
   }
   ```

### 7.接口

#### a.使用interface来定义接口，子类调用该接口的时，必须重写该接口中的所有抽象方法。

```定义接口
public interface Drivable {
    // 常量：默认是 public static final
    String TYPE = "Vehicle";

    // 抽象方法：默认是 public abstract
    void startEngine();
    void accelerate(int speed);

    // Java 8 之后允许有 default 方法（有具体实现的方法）
    default void stop() {
        System.out.println("The vehicle is stopping.");
    }
}
```

```调用接口
public class Car implements Drivable {

    // 必须实现 Drivable 接口中的所有抽象方法
    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Car accelerating to " + speed + " km/h.");
    }

    // 可以选择性地继承 default 方法，也可以重写它
}
```

```
// Drivable 类型的引用可以指向 Car 类的实例
Drivable myCar = new Car();
myCar.startEngine(); // 实际调用的是 Car 类的 startEngine 方法
myCat.accelerate(50);
myCar.stop();        // 调用 default 方法
```

#### 接口较于抽象类的好处：突破了单继承的劣势，一个子类可以调用多个接口，拥有多个不相干的规范，很好的实现了模块的解耦。

#### 接口中的default方法是一个带有具体实现的方法，调用接口的类可以直接使用默认方法，也可以像重写普通方法一样重写 `default` 方法，提供自己的具体实现。

### 8.内部类

#### 内部类就是在外部类中还有一个类。内部类可以访问外部类的成员，外部类要访问内部类必须创建对象。分为：成员内部类、静态内部类、局部内部类和匿名内部类等。

成员内部类**定义在外部类的**类体内**（与属性、方法同级）。可以访问外部类**所有**成员（包括 `private` 成员）。外部类必须先创建对象才能创建成员内部类对象。**局部内部类**定义在外部类的**方法或代码块内部**。只能在定义它的方法或代码块内部使用。可以访问外部类的所有成员，但只能访问它所在方法中被 `final` 或 **effectively final** 修饰的局部变量。**匿名内部类**没有名称的类，通常在**实例化对象时**同时定义和创建。**最常用！**用于快速实现一个接口或继承一个抽象类，且只使用一次的场景。**没有构造方法**。**静态内部类**用 `static` 关键字修饰的内部类。行为上更像一个独立的类。**不能直接访问**外部类的非静态成员。创建它不需要先创建外部类对象。

### 

### a.重点一下匿名内部类（**重要）

格式：new 类名/接口名(  ) {

        重写方法;

};

这个新new的匿名内部类其实就可以看作一个新对象，例1如下：

```java
public class Dog extends Animals implements Eat {
    @Override
    public void method()
    {
        System.out.printf("这是狗类中的方法调用\n");
    }

    @Override
    public void have()
    {
        System.out.printf("这是狗类中的接口吃调用\n");
    }
}
/////以上是狗类

//测试类
public class test {
    public static void main(String[] args) {
        //按照以往的写法，调用dog和接口要新建对象
        Dog dog=new Dog();
        dog.method();
        dog.have();
        //这样每次调用方法时都要新建一个类，有点浪费

        //以下为使用匿名内部类的写法：
        //创建了一个临时的、没有名字的类，并且立即实例化这个对象
        Animals dog3=new Dog()
        {
            @Override
            public void method()
            {
                System.out.printf("这是调用匿名内部类的写法\n");
            }
        };
        Eat eat1=new Eat()    //接收接口对象就用接口名新建对象
        {
            @Override
            public void have()
            {
                System.out.printf("这是匿名内部类的接口\n");
            }
        };
        dog3.method();
        eat1.have();
        //作为一个对象它甚至可以调用自己的方法
        new Dog()
        {
            @Override
            public void method()
            {
                System.out.printf("这是匿名内部类");
            }
        }.method();

    }
}
```

例2

```java
//接口：
// 接口：定义了“被点击”这个行为规范
public interface ClickListener {
    void onClick(); // 抽象方法：点击后要做什么
}

//实现：
public class ButtonTest {

    public static void main(String[] args) {

        // ----------------------------------------------------
        // ❌ 传统写法（需要新建一个类文件）
        // ----------------------------------------------------
        // 步骤：1. 新建一个 MyClickAction.java 文件来实现 ClickListener 接口。
        //       2. 在这里实例化 MyClickAction 对象。

        // 传统写法代码展示 (假设 MyClickAction 类已存在)
        // ClickListener action1 = new MyClickAction();
        // action1.onClick(); 
        // 这种方式很规范，但如果这个动作只用一次，就很麻烦。


        // ----------------------------------------------------
        // ✅ 匿名内部类写法（简洁、优势所在）
        // ----------------------------------------------------

        System.out.println("--- 匿名内部类开始 ---");

        // 核心语法：new 接口名() { ... }
        // 优势：在创建对象的同时，立即定义了它的行为，且没有类名。
        ClickListener buttonAction = new ClickListener() {
            //上面用一个接口类型的对象来接收这个新建的匿名类
            // 语法点 1：必须在这里立即重写接口中的所有抽象方法
            @Override
            public void onClick() {
                System.out.println("动作一：播放音效。");
                System.out.println("动作二：更新界面文字。");
                // 在这里定义了按钮被点击后具体要做的事情
            }

            // 语法点 2：这个匿名类不能有构造方法
            // 语法点 3：这个匿名类可以访问 main 方法外部的 final 变量
        }; // 语句结束，不要忘记分号

        // 调用这个匿名类对象的方法
        System.out.print("按钮被点击了：");
        buttonAction.onClick();

        System.out.println("--- 匿名内部类结束 ---");
    }
}
//以前想要调用接口时都得先创建一个类来调用接口再在测试类中创建这个类的对象，
//现在相当于可以直接在测试类中调用接口了
```

#### 总之：当您需要创建一个类的实例，而这个类**只需要使用一次**，并且它的代码量**很少**时，就应该考虑使用匿名内部类。匿名内部类是 Java 中实现**一次性、局部化、小规模功能**的首选工具，它用简洁的语法解决了传统上需要创建多个文件的麻烦。

## 

## 二、集合进阶

### 1.单列集合顶层接口collection：相关方法的用法

#### 其中的.contains是用equal比较地址值来判断是否存在的
