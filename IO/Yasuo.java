import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


//注意：GZIP只能用于解压缩单文件，ZIP只能用于解压缩文件夹
public class Yasuo {
    public static void main(String[] args) throws IOException {

        // --- 修正 GZIP 压缩部分 ---
        try (OutputStream out = new FileOutputStream("data.gz"); // 使用 .gz 扩展名
             GZIPOutputStream zip = new GZIPOutputStream(out);
             InputStream source = new FileInputStream("copy2.txt")) { // 假设要压缩一个文件

            byte[] buffer = new byte[1024];
            int len;
            while ((len = source.read(buffer)) > 0) {
                zip.write(buffer, 0, len); // 实际写入数据
            }
            System.out.println("数据压缩完成，写入 data.gz");
        }

        // --- 修正 GZIP 解压部分 ---
        try (FileInputStream in = new FileInputStream("copy4.gz"); // 读取 .gz 文件
             GZIPInputStream zip2 = new GZIPInputStream(in);
             FileOutputStream dest = new FileOutputStream("uncompressed_copy.txt")) { // 写入解压后的文件

            byte[] buffer = new byte[1024];
            int len;
            while ((len = zip2.read(buffer)) > 0) {
                dest.write(buffer, 0, len); // 实际读取和写入解压后的数据
            }
            System.out.println("数据解压完成，写入 uncompressed_copy.txt");

        } catch (FileNotFoundException e) {
            System.err.println("文件未找到，请检查路径。");
        }
    }
}