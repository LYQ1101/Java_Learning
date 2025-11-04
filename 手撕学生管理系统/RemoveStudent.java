public class RemoveStudent {
    public void removeStudent(int id)
    {
        for (int i = 0; i < Control.students.size(); i++) {
            Student student=Control.students.get(i);
            if(student.getID()==id)
            {
                Control.students.remove(i);
                System.out.printf("id号为%d的学生已删除\n",id);
                return ;
            }
            else
            {
                System.out.println("未找到该id号的学生\n");
                return ;
            }
        }
    }


}
