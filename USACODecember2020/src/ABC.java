import java.util.*;
import java.io.*;

public class ABC {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACODecember2020\\src\\ABC.in"));
        Scanner sc = new Scanner(System.in);

        long[] arr = new long[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = sc.nextInt();
        }
        long a; long b; long c;
        Arrays.sort(arr);
        a = arr[0];
        b = arr[1];
        if ((a + b) > arr[2]) {
            c = arr[2];
        }
        else
            c = arr[3];

        System.out.println(a + " " + b + " " + c);
    }
}
