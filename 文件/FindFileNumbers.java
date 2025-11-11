import java.io.File;

public class FindFileNumbers {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\lyq\\Desktop\\");
        findAvi(file);
        System.out.print(txtnumbers+" ");
        System.out.print(jpgnumbers+" ");
        System.out.print(docxnumbers);
    }

    static int txtnumbers=0;
    static int jpgnumbers=0;
    static int docxnumbers=0;
    static void findAvi(File file)
    {

        File[] files=file.listFiles();
        if(files!=null) {
            for (File i : files) {
                if (i.isFile() && i.getName().endsWith(".txt")) {
                    System.out.print(i+"\n");
                    txtnumbers+=1;
                } else if (i.isFile() && i.getName().endsWith(".jpg")) {
                    System.out.print(i+"\n");
                    jpgnumbers+=1;
                } else if (i.isFile() && i.getName().endsWith(".docx")) {
                    System.out.print(i + "\n");
                    docxnumbers += 1;
                }
                else {
                    findAvi(i);
                }
            }
        }
    }
}
