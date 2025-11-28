import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;

public class Receive { // 类名拼写修正
    public static void main(String[] args) {
        // 将Socket创建放在循环外，避免重复绑定端口
        try (DatagramSocket socket = new DatagramSocket(8888)) {
            byte[] buffer = new byte[1024];

            while (true) {
                // 1. 创建DatagramPacket对象用于接收数据
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // 2. 阻塞等待接收数据
                socket.receive(packet);

                // 3. 解析接收到的字节数组为字符串
                String receivedData = new String(packet.getData(), 0, packet.getLength());

                // 4. 输出接收到的内容
                System.out.println("接收到的内容：" + receivedData);
            }
        } catch (SocketException e) {
            System.err.println("Socket绑定失败：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("接收数据失败：" + e.getMessage());
        }
    }
}