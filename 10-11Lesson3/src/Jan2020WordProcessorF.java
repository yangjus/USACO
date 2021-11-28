import java.util.*;
import java.io.*;

public class Jan2020WordProcessorF{
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:/Users/Jonathan/IdeaProjects/USACOBRONZE/Word Processor/2.in"));
        Scanner sc = new Scanner(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        int numWords = sc.nextInt();
        int maxChars = sc.nextInt();
        String current;
        int count = 0;
        boolean first = true;
        for (int i = 0; i < numWords; i++){
            current = sc.next();
            if (count + current.length() > maxChars){
                //System.out.println();
                //System.out.print(current);
                pw.println();
                pw.print(current);
                count = current.length();
            }
            else{
                if (first){
                    //System.out.print(current);
                    pw.print(current);
                    first = false;
                }
                else{
                    //System.out.print(" " + current);
                    pw.print(" " + current);
                }
                count += current.length();
            }
        }
        pw.close();
    }
}