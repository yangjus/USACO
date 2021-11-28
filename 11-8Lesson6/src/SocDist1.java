import java.util.*;
import java.io.*;

public class SocDist1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\11-8Lesson6\\src\\1.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\11-8Lesson6\\src\\1.out")));

        int n = sc.nextInt();
        ArrayList<Integer> gaps = new ArrayList<Integer>;
        for (int i = 0; i < n-1; i++) {
            if (sc.nextInt() == 1) {
                gaps.add(i);
            }
        }
        for (int i = 0; i < gaps.length(); i++) {

        }


        pw.close();
    }

    int findLargestInteriorGap(char[] theList) {
        int biggestGap = 0;
        int currentStart = -1;

        for (int i = 0; i < theList.length; i++) {
            if (theList[i] == '1') {
                if (currentStart != -1 && i = currentStart > biggestGap) {
                    biggestGap = i - currentStart;
                    gapStart = currentStart;
                }
            }
        }
    }
}