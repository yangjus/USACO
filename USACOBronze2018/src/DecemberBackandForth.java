import java.util.*;
import java.io.*;

public class DecemberBackandForth {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\backforth.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\backforth.out")));
        //Scanner sc = new Scanner(new FileReader("backforth.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));

        List<Integer> b1 = new ArrayList<>();
        List<Integer> b2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            b1.add(sc.nextInt());
        }
        for (int i = 0; i < 10; i++) {
            b2.add(sc.nextInt());
        }

        tuesday(1000, b1, b2);

        int answer = 0;
        for (int i = 0; i < 2000; i++) {
            answer += possible_answers[i];
        }
        System.out.println(answer);
        pw.println(answer);
        pw.close();
    }
    private static int[] possible_answers = new int [2000];

    static void friday(int b1milk, List<Integer> B1, List<Integer> B2)
    {
        for (int i=0; i<B2.size(); i++) {
            int x = B2.get(i);
            possible_answers[b1milk + x] = 1; // record this value as possible
        }
    }

    static void thursday(int b1milk, List<Integer> B1, List<Integer> B2)
    {
        for (int i=0; i<B1.size(); i++) {
            int x = B1.get(i);
            List<Integer> new_B2 = B2; new_B2.add(x);
            List<Integer> new_B1 = B1; new_B1.remove(i);
            friday(b1milk - x, new_B1, new_B2);
        }
    }

    static void wednesday(int b1milk, List<Integer> B1, List<Integer> B2)
    {
        for (int i=0; i<B2.size(); i++) {
            int x = B2.get(i);
            List<Integer> new_B1 = B1; new_B1.add(x);
            List<Integer> new_B2 = B2; new_B2.remove(i);
            thursday(b1milk + x, new_B1, new_B2);
        }
    }

    static void tuesday(int b1milk, List<Integer> B1, List<Integer> B2)
    {
        for (int i=0; i<B1.size(); i++) {
            int x = B1.get(i);
            List<Integer> new_B2 = B2; new_B2.add(x);
            List<Integer> new_B1 = B1; new_B1.remove(i);
            wednesday(b1milk - x, new_B1, new_B2);
        }
    }
}
