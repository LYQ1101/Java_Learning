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

#### 其中的.contains是用equal比较地址值来判断是否存在的；利用迭代器Iterarater来遍历集合；利用增强for来遍历单列集合；List集合就是collection集合的一个子类继承。

### 3.双列集合Map：键和值一一对应；相关方法的用法

遍历方法

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.put("C", 3);

// 方式一：使用 for-each 循环遍历 entrySet（最推荐）
for (Map.Entry<String, Integer> entry : map.entrySet()) //增强for，每次创建
//一个键值对对象接收集合元素,map.entrySet()可以遍历整个集合并且返回
{
    String key = entry.getKey();     // 直接获取 Key
    Integer value = entry.getValue(); // 直接获取 Value
    System.out.println("Key: " + key + ", Value: " + value);
}
```

```java
// 方式二：使用 for-each 循环遍历 keySet
for (String key : map.keySet()) {
    // 每次迭代都需要调用 map.get(key) 来查找 Value
    Integer value = map.get(key); 
    System.out.println("Key: " + key + ", Value: " + value);
}
```

#### HashMap(重要)，LinkedMap，TreeMap

#### 集合类Collection

#### 

#### 一点迭代器、比较器的补充和例子

```java
    public void order(ArrayList<String > list)
    {
        Collections.sort(list, new Comparator<String>() {   //比较器用法
            @Override
            public int compare(String o1, String o2) {
                int value1=getValue(o1);    //这里获取了o1的值
                int value2=getValue(o2);
                int i=value1-value2;    //升序排序，返回负数时候v1排在v2前面，反之后面
                return i==0?0:i;
            }
        });
    }
```

## 

## 三、Lambda表达式

Lambda 表达式本质上是一个**匿名函数**（没有名称的函数）。

它的主要目的是**简化对函数式接口（Functional Interface）的实现**，用更紧凑的语法取代冗长的**匿名内部类**（Anonymous Inner Class）。

一个 Lambda 表达式由三个主要部分组成：

                        （参数列表）->  表达式/结构体

| **参数列表**             | 定义函数的输入参数。       | `(a, b)`，`s`，`()`               |
| -------------------- | ---------------- | ------------------------------- |
| **箭头** $\rightarrow$ | 将参数列表与函数体分隔开。    | `->`                            |
| **函数体**              | 定义函数要执行的操作或返回的值。 | `a + b`，`System.out.println(s)` |

其简化写法可以不用表达式/结构体的{}

**Lambda 最主要的使用场景就是作为方法参数传入，尤其是在 Stream API 中。代替匿名内部类**，如：

```java
// 传统匿名内部类实现 Runnable 接口
Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("传统方式启动线程");
    }
});

// 使用 Lambda 表达式实现 Runnable 接口 (Runnable 是一个函数式接口)，空参->表达式
Thread t2 = new Thread(() -> System.out.println("Lambda 方式启动线程"));

t2.start();
```

## 四、stream流

### 1.单列集合，双列集合，数组，零散数据调用stream流方法是不一样的

```java
//单列集合    直接用Collections中的stream    链式编程写法
scores.stream() // 1. 创建 Stream
              .filter(s -> s >= 80) // 2. 中间操作：过滤掉小于 80 的元素
              .forEach(s -> System.out.println("及格分数: " + s)); // 3. 终端操作：打印结果

//双列集合    必须对值或键操作
countryMap.entrySet().stream() // 1. 创建 Stream：Stream 里的元素是 Map.Entry<String, String>
                  .filter(entry -> entry.getValue().length() > 3) // 2. 过滤：首都（Value）长度大于 3
                  .forEach(entry -> { // 3. 打印：使用 entry.getKey() 和 entry.getValue() 
                      System.out.println("国家: " + entry.getKey() + ", 首都: " + entry.getValue());

//数组    Arrays调用
Arrays.stream(fruits) // 1. 创建 Stream
              .filter(f -> f.startsWith("A")) // 2. 过滤：以 'A' 开头
              .forEach(f -> System.out.println("A-开头水果: " + f)); // 3. 打印


//零散数据 of
Stream.of("Java", "C", "Python", "Go", "Ruby") // 1. 创建 Stream
              .filter(lang -> lang.length() >= 4) // 2. 过滤：长度大于等于 4
              .forEach(lang -> System.out.println("长于 4 的语言: " + lang)); // 3. 打印
```

```java
        //匿名内部类写法
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });
        //lambda表达式写法
        list.stream().forEach(s-> System.out.print(s));
```

### 2.stream流中常用的中间方法

| **场景**  | **传统完整写法**                                         | **Lambda 简化写法**                                    | **解释**                                          |
| ------- | -------------------------------------------------- | -------------------------------------------------- | ----------------------------------------------- |
| **无参数** | `() -> { System.out.println("Hello"); }`           | `() -> System.out.println("Hello")`                | 必须保留空括号 `()`。                                   |
| **单参数** | `(s) -> { System.out.println(s); }`                | `s -> System.out.println(s)`                       | **可以省略参数的类型和外层的括号 `()`。**                       |
| **多参数** | `(x, y) -> { return x + y; }`                      | `(x, y) -> x + y`                                  | **多参数时，参数外的括号 `()` 不能省略。**                      |
| **单行体** | `(x) -> { return x * x; }`                         | `x -> x * x`                                       | **如果函数体只有一行返回语句，可以省略 `{}` 和 `return` 关键字。**     |
| **多行体** | `(s) -> { int len = s.length(); return len > 5; }` | `(s) -> { int len = s.length(); return len > 5; }` | **多行语句时，必须使用 `{}` 包裹，并使用 `return` 返回（如果有返回值）。** |

### 3.stream流中常用的终结方法（写在流中的最后，后面允许再调用）

| **类别**                  | **方法**                                    | **目的/用途**                                              | **返回值类型**                              |
| ----------------------- | ----------------------------------------- | ------------------------------------------------------ | -------------------------------------- |
| **收集/转换 (Collector)**   | **`collect(Collector)`**                  | 将 Stream 中的元素汇集成一个**新的集合**（List, Set, Map）或一个**单一结果**。 | `List<T>`, `Set<T>`, `Map<K, V>` 或其它类型 |
| **遍历/消耗 (Consumption)** | **`forEach(Consumer)`**                   | 对 Stream 中的每个元素执行一个**动作**。                             | `void`                                 |
| **统计/聚合 (Reduction)**   | **`count()`**                             | 返回 Stream 中的元素总数。                                      | `long`                                 |
|                         | **`max(Comparator)` / `min(Comparator)`** | 找出 Stream 中的最大或最小元素。                                   | `Optional<T>`                          |
|                         | **`reduce(BinaryOperator)`**              | 通过重复应用一个操作，将所有元素**归约为一个单一结果**。                         | `Optional<T>` 或 `T`                    |
| **查找/匹配 (Matching)**    | **`anyMatch(Predicate)`**                 | 检查 Stream 中**是否有**元素匹配给定条件。                            | `boolean`                              |
|                         | **`allMatch(Predicate)`**                 | 检查 Stream 中**所有**元素是否都匹配给定条件。                          | `boolean`                              |
|                         | **`findFirst()` / `findAny()`**           | 找出 Stream 中的**第一个**或**任意一个**元素。                        | `Optional<T>`                          |

## 

## 五、方法引用

### 1.一句话总结：把已有的方法拿过来用，当作函数接口中抽象方法的方法体。(似乎比lambda表达式的简化形式还要简化)

```java
//例如这个lambda表达式的简化形式
Arrays.sort(arr,(a1,a2)->a2-a1);

//用方法引用就是这样：
Arrays.sort(arr,类.该类中的方法);
```

方法引用就是 Java 编译器帮您自动推断并生成 Lambda 表达式的简洁语法，只要您想做的就是**调用一个已经存在的方法**，就可以考虑使用方法引用。

| **特性**  | **描述**                                                        |
| ------- | ------------------------------------------------------------- |
| **定义**  | 一种简洁的语法，用于直接引用已存在的方法（按名称引用），而不是提供完整的 Lambda 体。                |
| **符号**  | 使用双冒号 `::` 作为分隔符。                                             |
| **用途**  | 替代那些功能是**直接调用一个方法**的 Lambda 表达式。                              |
| **前提**  | 必须用于**函数式接口（Functional Interface）**，即接口中只有一个抽象方法。并且引用的方法已经存在。 |
| **兼容性** | 被引用的方法必须具有**兼容的函数签名**（参数的数量、类型和返回类型必须与函数式接口的抽象方法兼容）。          |

大致分为三种：引用静态方法，引用成员方法，引用构造方法

| 类型                | 语法格式                                                      | 适用场景                          | 示例                    | 对应的lambda表达式                   |
| ----------------- | --------------------------------------------------------- | ----------------------------- | --------------------- | ------------------------------ |
| **静态方法引用**        | `类名::静态方法名`                                               | Lambda 表达式体调用一个静态方法。          | `Math::max`           | `(a, b) -> Math.max(a, b)`     |
| **成员方法引用 (特定对象)** | `类.对象::实例方法名`<br/>如果对象是本类，就this::实例方法<br/>父类，就super::实例方法 | Lambda 表达式体调用一个**特定对象**的实例方法。 | `System.out::println` | `(x) -> System.out.println(x)` |
| **成员方法引用 (任意对象)** | `类名::实例方法名`(直接用类名引用)                                      | Lambda 表达式的**第一个参数**作为方法的调用者。 | `String::length`      | `(str) -> str.length()`        |
| **构造方法引用**        | `类名::new`                                                 | 引用构造方法来创建新的对象。                | `ArrayList::new`      | `() -> new ArrayList()`        |

易混淆的特定对象和任意对象的成员方法引用

```java
//1.特定对象    Lambda 表达式体调用一个**特定对象**的实例方法。
// 假设的打印服务类    
class PrintService {
    public void print(String s) { 
        System.out.println("打印: " + s); 
    }
}

PrintService printer = new PrintService(); // 📌 特定对象

// 1. Lambda 表达式
Consumer<String> consumerLambda = s -> printer.print(s);

// 2. 方法引用
Consumer<String> consumerRef = printer::print; 
// 效果：引用了 printer.print(String) 方法。
// Lambda 只接收一个参数 s，这个 s 作为 print 方法的参数。

// Lambda 参数数 (1) == 引用方法参数数 (1)


//2.任意对象    Lambda 表达式的**第一个参数**作为方法的调用者。
List<String> words = Arrays.asList("Apple", "Banana", "Cat", "Dog", "Elephant");

        // 1. 使用 Lambda 表达式实现按长度比较
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        // 输出: [Cat, Dog, Apple, Banana, Elephant]

        // 2. 使用类的任意对象实例方法引用：String::compareTo
        // -----------------------------------------------------------
        // 假设我们想按字典顺序不区分大小写排序
        // Comparator<String> 的 compare 方法需要 (String o1, String o2) 两个参数

        words.sort(String::compareToIgnoreCase); 
        // 效果：(String s1, String s2) -> s1.compareToIgnoreCase(s2)
```

小练习

```java
//Student中已重写相关方法和定义getName
public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"林,1","张三,22","急啊家的,21","李四,55");
        //把集合的元素转换为学生类并加入到一个数组中
        Student[]stu= list.stream().map(Student::new).toArray(Student[]::new);
        Arrays.stream(stu).sequential().forEach(System.out::print);

        String[]stu_name=list.stream()
                .map(Student::new)
                .map(Student::getName).toArray(String[]::new);
                //此处map中getName得到的是一堆String的，所以toArray要转成String类型的数组，接收那也要该
        Arrays.stream(stu_name).forEach(System.out::print);
    }
}
```

## 

## 六、异常

### 1.异常体系中最上层的父类是Exception，分为编译时异常和运行时异常。

### 2.捕获异常：①try{ 可能出现异常的代码 }catch(异常类名 变量名){  异常的处理代码  }

```java
        int[]arr={1,2,3};
        try {
            System.out.print(arr[4]);//如果出现异常，程序就会在这创建一个ArrayIndexOutOfBoundsException 对象
        //拿着这个对象和catch里面的对象比较，如果能被接收就表示能被捕获
        //执行catch里面对应的代码
        }
        catch (ArrayIndexOutOfBoundsException e)//数组索引越界类
        {
            System.out.printf("数组索引越界了\n");
        }
        System.out.printf("检测是否走到这一步");
```

### 3.异常常用的几种类方法：

```java
getMessage()        将此异常的详细信息作为一个字符串返回
toString()            将此异常的简短信息作为一个字符串返回
printStackTrace()    把异常的错误信息输出在控制台，包含信息最多
```

## 4.抛出异常

![](C:\Users\lyq\AppData\Roaming\marktext\images\2025-11-09-19-25-02-image.png)

```java
    public static int getOne(int[] arr) throws NegativeArraySizeException,NullPointerException
    {
        if(arr==null)
            //手动创建一个异常对象，并把这个异常方法交给调用者处理，后面的代码不会再执行了
            throw new RuntimeException();
        return arr[0];
    }
```

注：使用：throw new RuntimeException();可以直接抛出异常，不用再描述异常的具体种类，就单单表示出现了异常

连起来：在try中执行的代码块抛出某个类型的异常的时候（throw 。。。）,在对应的catch括号的异常类型（对应throw后的异常类型）对应的执行代码块中就可以对这个异常进行处理。

一个自定义异常和前面的综合小例子：

```java
public class InsufficientFundsException extends Exception {
    //Exception类中有message属性还有getMessage方法
    // 建议：添加一个带字符串参数的构造方法
    // 这个参数 (message) 将作为异常的详细描述
    public InsufficientFundsException(String message) {
        // 调用父类 Exception 的构造方法
        // 从而将 message 存储在异常对象中
        super(message);
    }
}


public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 重点：方法签名上必须声明 'throws InsufficientFundsException'
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            // 抛出我们自定义的异常，并附带详细信息
            double needed = amount - balance;
            String message = "取款失败：余额不足。需要 $" + needed + " 才能完成取款 $" + amount + "。";

            throw new InsufficientFundsException(message);
        }

        balance -= amount;
        System.out.println("成功取出 $" + amount + "。当前余额: $" + balance);
    }
}```
```

```java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.00); // 初始余额 $500

        try {
            System.out.println("尝试取款 $300...");
            account.withdraw(300.00); // 第一次：成功

            System.out.println("\n尝试取款 $400...");
            account.withdraw(400.00); // 第二次：余额不足，抛出异常

            // 如果成功，会执行下面的代码
            System.out.println("这一行不会被执行到，因为异常已抛出。");

        } catch (InsufficientFundsException e) {
            // 捕获并处理自定义异常
            System.err.println("\n[异常捕获] 错误信息:");
            System.err.println(e.getMessage());

            // e.printStackTrace(); 打印完整的堆栈信息
        }
    }
}
```

## 

## 七、文件

###### A、创建 `File` 对象（文件路径的抽象表示）

创建 `File` 对象只是在内存中表示一个路径，并不会立即在文件系统上创建实际的文件或目录。

#### 1. 构造方法与语法

| **构造方法**                                    | **示例**                                                                      | **说明**                 |
| ------------------------------------------- | --------------------------------------------------------------------------- | ---------------------- |
| **`new File(String pathname)`**             | `File f1 = new File("c:/data/test.txt");`                                   | 使用一个字符串作为文件或目录的完整路径。   |
| **`new File(String parent, String child)`** | `File f2 = new File("c:/data", "test.txt");`                                | 将父路径和子路径分开传入，更灵活。      |
| **`new File(File parent, String child)`**   | `File dir = new File("c:/data");`<br>`File f3 = new File(dir, "test.txt");` | 使用已存在的 `File` 对象作为父目录。 |

#### 2. 注意事项

- **路径分隔符：** 推荐使用 `/` (正斜杠) 或 `\\` (双反斜杠) 来确保跨平台兼容性。

- **绝对路径 vs 相对路径：** 相对路径是相对于当前程序运行目录而言的。

---

### B、基本文件/目录操作

这些方法用于在文件系统中创建、删除和重命名实际的物理文件或目录。

| **方法**                            | **返回值**        | **作用和语法**                                            |
| --------------------------------- | -------------- | ---------------------------------------------------- |
| **`boolean mkdir()`**             | `true`/`false` | 创建由该对象表示的**单个**目录。**父目录必须已存在**。                      |
| **`boolean mkdirs()`**            | `true`/`false` | 创建由该对象表示的目录，**包括所有必需但不存在的父目录**。**（推荐使用）**            |
| **`boolean createNewFile()`**     | `true`/`false` | 创建一个新的空文件。如果文件已存在，返回 `false`。**需要处理 `IOException`。** |
| **`boolean delete()`**            | `true`/`false` | 删除此对象表示的文件或空目录。非空目录无法删除。                             |
| **`boolean renameTo(File dest)`** | `true`/`false` | 将文件或目录重命名或移动到 `dest` 指定的新位置。                         |

#### 实例代码（创建目录）

Java

```
import java.io.File;

// 创建多级目录（推荐）
File dir = new File("D:/my_notes/java_io/files"); 
if (dir.mkdirs()) {
    System.out.println("目录创建成功!");
}
```

---

### C、查询文件/目录属性

这些方法用于检查文件或目录的状态和元信息。

| **方法**                         | **返回值**        | **作用**                       | **示例**                         |
| ------------------------------ | -------------- | ---------------------------- | ------------------------------ |
| **`boolean exists()`**         | `true`/`false` | 测试此路径表示的文件或目录是否**实际存在**。     | `if (f.exists()) { ... }`      |
| **`boolean isFile()`**         | `true`/`false` | 测试此路径是否为**文件**。              | `if (f.isFile()) { ... }`      |
| **`boolean isDirectory()`**    | `true`/`false` | 测试此路径是否为**目录**。              | `if (f.isDirectory()) { ... }` |
| **`String getName()`**         | `String`       | 返回文件或目录的**名称**（路径的最后一部分）。    | `f.getName()` // "test.txt"    |
| **`String getPath()`**         | `String`       | 返回创建 `File` 对象时使用的**路径字符串**。 |                                |
| **`String getAbsolutePath()`** | `String`       | 返回文件或目录的**绝对路径**。            |                                |
| **`long length()`**            | `long`         | 返回文件的**字节大小**。如果是目录，结果是不确定的。 |                                |

---

### D、列出目录内容

这些方法用于获取一个目录下的文件和子目录列表。

| **方法**                   | **返回值**    | **作用**                                           |
| ------------------------ | ---------- | ------------------------------------------------ |
| **`String[] list()`**    | `String[]` | 返回目录中文件和目录的**名称**数组（`String` 类型）。                |
| **`File[] listFiles()`** | `File[]`   | 返回目录中文件和目录的**`File` 对象**数组（`File` 类型）。**（推荐使用）** |

#### 实例代码（遍历目录）

Java

```
import java.io.File;

File dir = new File("c:/MyData");
// 推荐使用 listFiles() 获取 File 对象
File[] items = dir.listFiles(); 

if (items != null) {
    for (File item : items) {
        if (item.isDirectory()) {
            System.out.println("[目录]: " + item.getName());
        } else if (item.isFile()) {
            System.out.println("[文件]: " + item.getName() + " (" + item.length() + " 字节)");
        }
    }
}
```

---

### 总结

`File` 类是进行任何文件读写操作（使用 `FileInputStream`/`FileOutputStream` 等流）的**基础**。掌握它的基本构造和操作方法，是进行 Java I/O 编程的第一步。

## 

## 八、IO流

### 1.字节流、字符流

### 2.其下的基本流

### 3.再下的缓冲流

### 4.再下的转换流

### 5.序列化流和反序列化

### 6.字节和字符输出流

### 7.压缩流和解压流

### 8.常用工具包commons-io

### 9.常用工具包hutool





## 九、多线程

### 1.创建进程的三种方式

### 2.线程中常见的方法

### 3.同步代码块    小tips:StringBuffer相较于StringBuilder的一个很大区别就是前者的每个方法都有synchronized



## 十、网路编程
