import java.util.*;
import java.io.*;

public class Jan2020WordProcessor {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("word.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));

        int n = sc.nextInt();
        int k = sc.nextInt();
        int charTotal = 0;
        String current;

        //for first string
        current = sc.next();
        out.print(current);
        charTotal += current.length();

        for (int i = 1; i < n; i++) {
            current = sc.next();
            if (charTotal + current.length() > k) {  //if over K max
                out.println();
                out.print(current);
                charTotal = current.length();
            }
            else {
                out.print(" " + current);
                charTotal += current.length();
            }
        }
        out.close();
    }
}
