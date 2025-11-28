import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888); // 连接本地 8888 端口
        OutputStream os = socket.getOutputStream();
        os.write("你好，Java网络编程".getBytes()); // 发送数据
        socket.close();
    }
}
