import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    public static ArrayList<Student> students=new ArrayList<>();   //把学生列表直接作为全体文件可以访问的公共量
    public static void main(String[] args)
    {
        String input="-1";
        while (!input.equals("0"))
        {
            System.out.println("\n欢迎来到学生管理系统，请输入数字操作：1增，2删，3查，4改，5输出所有学生学习，0退出");
            Scanner sc=new Scanner(System.in);
            input=sc.next();
            switch (input)
            {
                case "1":
                    System.out.println("请输入您要加入的学生信息：id-name-age-address");
                    int id=sc.nextInt();
                    sc.nextLine(); // 放在每个 nextInt 后面清掉回车
                    String name=sc.next();
                    sc.nextLine();
                    int age=sc.nextInt();
                    sc.nextLine();
                    String address=sc.next();

                    AddStudent do_add=new AddStudent();
                    do_add.addStudent(id,name,age,address);
                    break;
                case "2":
                    System.out.println("请输入您要删除的学生ID");
                    int id2=sc.nextInt();
                    sc.nextLine();
                    RemoveStudent remove=new RemoveStudent();
                    remove.removeStudent( id2);
                    break;
                case "3":
                    System.out.println("请输入你要查找的学生学号");
                    int id3=sc.nextInt();
                    sc.nextLine();
                    FindStudent findstudent=new FindStudent();
                    findstudent.findStudent(id3);
                    break;
                case "4":
                    System.out.println("请输入你要查找的学生的学号");
                    int find_id=sc.nextInt();
                    sc.nextLine();
                    FindStudent find_in_remove=new FindStudent();
                    boolean find=find_in_remove.findStudent(find_id);
                    if(find)
                    {
                        System.out.println("请输入你要修改的学生信息（id-name-age-address）");
                        int id4=sc.nextInt();
                        sc.nextLine();
                        String name4=sc.next();
                        int age4=sc.nextInt();
                        sc.nextLine();
                        String address4=sc.next();

                        ChangeStudent change=new ChangeStudent();
                        change.changeStudent(find_id,id4,name4,age4,address4);
                    }
                    else {
                        System.out.printf("未找到id号为%d的学生",find_id);
                    }
                    break;
                case "5":
                    PrintStudent print =new PrintStudent();
                    print.printStudent();
                    break;
            }
        }

    }

}
