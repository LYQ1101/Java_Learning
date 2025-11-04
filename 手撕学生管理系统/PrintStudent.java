public class PrintStudent {
    public void printStudent()
    {
        for (int i = 0; i < Control.students.size(); i++) {
            Student student=Control.students.get(i);
            System.out.printf("ID：%d    姓名：%s   年龄：%d   地址：%s\n",student.getID(),student.getName(),student.getAge(),student.getAddress());
        }
        System.out.println("所有学生信息输出完毕\n");
    }

}
