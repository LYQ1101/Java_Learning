import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888); // 监听 8888 端口
        System.out.println("等待连接...");
        Socket socket = serverSocket.accept(); // 阻塞，直到有客户端连接
        System.out.println("连接成功！");

// 读取数据
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        System.out.println("收到消息: " + new String(buffer, 0, len));

        socket.close();
        serverSocket.close();
    }
}
