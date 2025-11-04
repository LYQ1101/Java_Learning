public class Student {
    String name;
    int age;
    int id;
    String address;

    public Student()    //默认构造函数
    {
        id=-1;
        name="未知";
        age=-1;
        address="未知";
    }
    public Student(int id,String name,int age,String address)    //默认构造函数
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    void setName(String name)
    {
        this.name=name;
    }
    String getName()
    {
        return this.name;
    }

    void setID(int id)
    {
        this.id=id;
    }
    int getID()
    {
        return this.id;
    }

    void setAge(int age)
    {
        this.age=age;
    }
    int getAge()
    {
        return this.age;
    }

    void setAddress(String address)
    {
        this.address=address;
    }
    String getAddress()
    {
        return this.address;
    }

}
