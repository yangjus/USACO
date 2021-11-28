import java.util.*;
import java.io.*;

public class DecemberMixingMilk {
        public static void main (String[] args) throws IOException {
            //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\mixmilk.in"));
            //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\mixmilk.out")));
            Scanner sc = new Scanner(new FileReader("mixmilk.in"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

            int c1 = sc.nextInt();
            int m1 = sc.nextInt();
            int c2 = sc.nextInt();
            int m2 = sc.nextInt();
            int c3 = sc.nextInt();
            int m3 = sc.nextInt();
            int prevAmounts[] = new int[]{m1, m2, m3};

            for (int i = 0; i < 33; i++) {  //(m1 -> m2 -> m3 -> m1) x 33
                //pour m1 to m2
                if ((m1 + m2) <= c2) { //if m1 will not overfill c2
                    m2 = m1 + m2;
                    m1 = 0;
                }
                else { //if m1 will overfill c2
                    m1 = m1 + m2 - c2;
                    m2 = c2;
                }
                //pour m2 to m3
                if ((m2 + m3) <= c3) {
                    m3 = m2 + m3;
                    m2 = 0;
                }
                else {
                    m2 = m2 + m3 - c3;
                    m3 = c3;
                }
                //pour m3 to m1
                if ((m3 + m1) <= c1) {
                    m1 = m3 + m1;
                    m3 = 0;
                }
                else {
                    m3 = m3 + m1 - c1;
                    m1 = c1;
                }
                //if bucket amounts of m1, m2, m3, are repeated
                if (prevAmounts[0] == m1 && prevAmounts[1] == m2 && prevAmounts[2] == m3) {
                    break;  //close loop, not necessary anymore
                }
                prevAmounts[0] = m1;
                prevAmounts[1] = m2;
                prevAmounts[2] = m3;
            }
            //final, 100th pour: pour m1 to m2
            if ((m1 + m2) <= c2) {
                m2 = m1 + m2;
                m1 = 0;
            }
            else {
                m1 = m1 + m2 - c2;
                m2 = c2;
            }
            pw.println(m1);
            pw.println(m2);
            pw.println(m3);
            pw.close();
    }
}
