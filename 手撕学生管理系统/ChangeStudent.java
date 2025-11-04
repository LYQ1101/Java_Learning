public class ChangeStudent {
    public void changeStudent(int findid,int id,String name,int age,String address)
    {
        for (int i = 0; i <Control.students.size() ; i++) {
            Student student=Control.students.get(i);
            if(student.getID()==findid)
            {
                student.setID(id);
                student.setAge(age);
                student.setName(name);
                student.setAddress(address);
                System.out.printf("id为%d的学生信息修改完成",findid);
                return;
            }

        }
    }

}
