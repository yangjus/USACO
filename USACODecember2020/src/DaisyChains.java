import java.util.*;
import java.io.*;

public class DaisyChains {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACODecember2020\\src\\chains.in"));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int avg_flower_photos = n;

        for (int i = 0; i < n-1; i++) { //iterate photos taken
            for (int j = i+1; j < n; j++) { //pair of (i,j)
                double sum = 0;
                double count = 0;
                boolean contains_avg = false;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    count++;
                }
                for (int a = i; a <= j; a++) {
                    //if current flower's petals = average petals
                    if (arr[a] == (sum / count)) {
                        contains_avg = true;
                    }
                }
                if (contains_avg) {
                    avg_flower_photos++;
                    //System.out.println("(" + i + "," + j + "): True");
                }
                //else
                    //System.out.println("(" + i + "," + j + "): False");
            }
        }
        System.out.println(avg_flower_photos);
    }
}
