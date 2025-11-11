import java.io.File;

public class FindFile {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\lyq\\Desktop\\");
        findAvi(file);
    }
    static void findAvi(File file)
    {

        File[] files=file.listFiles();
        if(files!=null) {
            for (File i : files) {
                if (i.isFile() && i.getName().endsWith(".txt")) {
                    System.out.print(i+"\n");
                } else {
                    findAvi(i);
                }
            }
        }
    }


}
