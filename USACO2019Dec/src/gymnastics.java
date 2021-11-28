import java.util.*;
import java.io.*;

public class gymnastics {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACO2019Dec\\src\\2.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\USACO2019Dec\\src\\2.out")));
        Scanner sc = new Scanner(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        int k = sc.nextInt();   //# of practices
        int n = sc.nextInt();   //# of cows
        int distinct = 0;

        int[][] cows = new int[k][n];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < n; i++) {
                cows[j][i] = sc.nextInt();  //set up array
            }
        }
        int tempTotal = 0;
        for (int a = 1; a <= n; a++) {  //brute force all (a,b) combinations
            for (int b = 1; b <= n; b++) {
                for (int session = 0; session < k; session++) { //test every session
                    int apos = 0;
                    int bpos = 0;
                    for (int i = 0; i < n; i++) {
                        if (cows[session][i] == a) {
                            apos = i;   //find position of cow A
                        }
                        if (cows[session][i] == b){
                            bpos = i;   //find position of cow B
                        }
                    }
                    if (apos < bpos) {
                        tempTotal++;    //a < b in this session
                    }
                }
                if (tempTotal == k) {   //if a < b is true in all sessions
                    distinct++;
                }
                tempTotal = 0;  //reset tempTotal for next possible (a,b) iteration
            }
        }
        System.out.println(distinct);
        pw.println(distinct);
        pw.close();
    }
}
