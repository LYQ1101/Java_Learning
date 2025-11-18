import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


//现在都推荐用字符输出流
public class IOprint {
        public static void main(String[] args) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt"), true)) { // true 启用自动刷新
                pw.println("这是一个字符打印流的示例。");
                pw.println(12345); // 自动将 int 转换为 String
                pw.println(3.14159); // 自动将 double 转换为 String
                pw.printf("格式化输出: %s, %d\n", "Java", 2025); // 支持格式化
                // 因为启用了 autoFlush，上面的 println 会立即写入文件
                System.out.println("数据已写入 output.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
