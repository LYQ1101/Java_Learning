import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Send {
    public static void main(String[] args) throws IOException {

        int n=1;
        while(n!=0) {
            //先创建DatagramSocket
            DatagramSocket socket=new DatagramSocket();

            Scanner scan=new Scanner(System.in);
            String str=scan.next();
            if(str.equals(0)){
                System.out.printf("\n退出系统！");
                break;
            }
            byte[] bytes = str.getBytes();

            //配置参数
            InetAddress ip=InetAddress.getByName("127.0.0.1");  //配置ip
            int port=8888;  //配置端口

            //打包
            DatagramPacket db=new DatagramPacket(bytes,bytes.length,ip,port);

            //发送
            socket.send(db);
            System.out.printf("消息发送成功！");

            //关闭
            socket.close();


        }
    }
}
