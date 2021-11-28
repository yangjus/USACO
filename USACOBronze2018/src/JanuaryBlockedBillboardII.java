import java.util.*;
import java.io.*;

public class JanuaryBlockedBillboardII {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\billboard.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\billboard.out")));
        Scanner sc = new Scanner(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        int Lx1 = sc.nextInt(); //L = Lawnmower billboard
        int Ly1 = sc.nextInt();
        int Lx2 = sc.nextInt();
        int Ly2 = sc.nextInt();
        int Fx1 = sc.nextInt(); //F = cow Feed billboard
        int Fy1 = sc.nextInt();
        int Fx2 = sc.nextInt();
        int Fy2 = sc.nextInt();
        int area = 0;

        //First Scenario: if F billboard completely obscures L billboard
        if ((Fx1 <= Lx1) && (Fy1 <= Ly1) && (Fx2 >= Lx2) && (Fy2 >= Ly2)) {
            area = 0;
        }
        //Second Scenario: if F billboard obscures 2 corners of L billboard
        else if ((Fx1 < Lx2) && (Fx2 >= Lx2) && (Fy1 <= Ly1) && (Fy2 >= Ly2)) { //right 2 corners
            area = calculate_area(Lx1, Ly1, Fx1, Ly2);
        }
        else if ((Fx1 <= Lx1) && (Fx2 > Lx1) && (Fy1 <= Ly1) && (Fy2 >= Ly2)) { //left 2
            area = calculate_area(Fx2, Ly1, Lx2, Ly2);
        }
        else if ((Fy1 < Ly2) && (Fy2 >= Ly2) && (Fx1 <= Lx1) && (Fx2 >= Lx2)) { //top 2
            area = calculate_area(Lx1, Ly1, Lx2, Fy1);
        }
        else if ((Fy1 < Ly1) && (Fy2 >= Ly1) && (Fx1 <= Lx1) && (Fx2 >= Lx2)) { //bottom 2
            area = calculate_area(Lx1, Fy2, Lx2, Ly2);
        }
        //Third Scenario: if F billboard obscures, 1, 3, or no corners of L billboard
        else
            area = calculate_area(Lx1, Ly1, Lx2, Ly2);

        System.out.println(area);
        pw.println(area);
        pw.close();
    }

    static int calculate_area(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (y2 - y1);
    }
}
