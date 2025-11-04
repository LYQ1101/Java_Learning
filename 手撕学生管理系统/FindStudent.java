public class FindStudent {
    public boolean findStudent(int id)
    {
        for (int i = 0; i < Control.students.size(); i++) {
            Student student=Control.students.get(i);
            if(student.getID()==id)
            {
                System.out.println("成功找到目标学生，学生信息如下：");
                System.out.printf("；ID为%d",id);
                System.out.println("；名字为"+student.getName());
                System.out.printf("；年龄为%d",student.getAge());
                System.out.println("；地址为"+student.getAddress());
                return true ;
            }
        }
        System.out.println("未找到目标学生，请继续操作\n");
        return false;
    }
}
