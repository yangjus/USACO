import java.util.Scanner;
import java.io.*;

public class SecondQuestion {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\Justin\\IdeaProjects\\9-20Lesson0\\src\\ReadFile1");
        Scanner sc = new Scanner(inputFile);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
                "C:\\Users\\Justin\\IdeaProjects\\9-20Lesson0\\src\\fileoutput1.out")));
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 1)
                pw.println(num + " " + sc.next());
            else
                pw.println(num + " " + sc.next() + "s");
        }
    pw.close();
    }
}