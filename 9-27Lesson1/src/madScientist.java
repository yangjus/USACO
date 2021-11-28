import java.util.Scanner;
import java.io.*;

public class madScientist {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("breedflip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
        //Gathering data
        int numCows = sc.nextInt();
        char[] a = new char[numCows];
        char[] b = new char[numCows];
        String A = sc.next();
        String B = sc.next();
        for (int i = 0; i < numCows; i++) {
            a[i] = A.charAt(i);
            b[i] = B.charAt(i);
        }
        //Finding not matching characters between A and B
        boolean[] matching = new boolean[numCows];
        for (int i = 0; i < numCows; i++) {
            if (a[i] == b[i])
                matching[i] = true;
            else
                matching[i] = false;
        }
        //If false matching boolean are next to each other, combine them
        int numOfFlips = 0;
        if (matching[0] == false) numOfFlips++; //so that matching[i-1] isn't null
        for (int i = 1; i < numCows; i++) { //if prev. index is not the same boolean
            if ((matching[i] == false) && (matching[i] != matching[i-1])) {
                numOfFlips++;
            }
        }

        pw.println(numOfFlips);
        pw.close();
        /* Testing
        for (int i = 0; i < numCows; i++) {
            System.out.println(b[i]);
        }
        System.out.println(numCows);
        System.out.println(A);
        System.out.println(B);
        */
    }

}
