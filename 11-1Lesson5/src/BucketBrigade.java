import java.util.*;
import java.io.*;

public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        int b_x = -1;
        int b_y = -1;
        int r_x = -1;
        int r_y = -1;
        int l_x = -1;
        int l_y = -1;
        for (int i = 0; i < 10; i++) {
            String strline = sc.next();
            for (int j=0; j < 10; j++) {
                switch (strline.charAt(j)) {
                    case 'B':
                        b_x = i;
                        b_y = j;
                        break;
                    case 'R':
                        r_x = i;
                        r_y = j;
                        break;
                    case 'L':
                        l_x = i;
                        l_y = j;
                        break;
                }
            }
        }
        int result = -1;
        result = Math.abs(l_x - b_x) + Math.abs(l_y - b_y) - 1;
        if ((l_x == b_x && r_x == l_x) || (l_y == b_y && r_y == l_y)) {
            if ((r_x > l_x && r_x < b_x) || (r_x > b_x && r_x < l_x)
                    || (r_y > l_y && r_y < b_y) || (r_y > b_y && r_y < l_y)) {
                result = result + 2;
            }
        }
        pw.println(result);
        pw.close();
    }
}
