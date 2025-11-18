import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader("infor.txt"));
        String line=bf.readLine();


        System.out.printf("请输入用户名和密码\n");
        String username;
        String password;

        String[] list=line.split("&");
        String[] list1=list[0].split("=");
        String[] list2=list[1].split("=");

        username=list1[1];
        password=list2[1];

        Scanner se=new Scanner(System.in);
        String s1=se.nextLine();
        String s2=se.nextLine();

        if(s1.equals(username)&&s2.equals(password)){
            System.out.printf("登陆成功");
        }else {
            System.out.printf("登陆失败");
        }


    }
}
