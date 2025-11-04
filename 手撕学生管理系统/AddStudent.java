public class AddStudent {
    public void addStudent(int id,String name,int age,String address)
    {
        Student student=new Student();
        student.setID(id);
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        Control.students.add(student);
        System.out.println("新学生添加完毕，请继续进行操作");
    }
}
