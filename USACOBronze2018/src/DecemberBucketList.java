import java.util.*;
import java.io.*;
import java.lang.*;

public class DecemberBucketList {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\blist.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\blist.out")));
        Scanner sc = new Scanner(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

        int n = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int minimumBuckets = 0;
        for (int time = 1; time <= 1000; time++) { //simulate event
            int buckets_at_the_time = 0; //reset counter for bucket at the time
            for (int i = 0; i < n; i++) { //iterate through each cow
                if (s[i] <= time && t[i] >= time) { //if time is in cow milking interval
                    buckets_at_the_time += b[i];
                }
            }
            //find the number of buckets needed at most
            minimumBuckets = Math.max(minimumBuckets, buckets_at_the_time);
        }

        System.out.println(minimumBuckets);
        pw.println(minimumBuckets);
        pw.close();
    }
}
