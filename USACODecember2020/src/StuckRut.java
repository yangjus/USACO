import java.util.*;
import java.io.*;

public class StuckRut {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACODecember2020\\src\\rut.in"));
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] direction = new char[n];
        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            direction[i] = sc.next().charAt(0);
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        //for (int i = 0; i < n; i++) {
        //    System.out.println(direction[i] + " " + x[i] + " " + y[i]);
        //}
        for (int i = 0; i < n; i++) { //iterates each cow
            long min_steps = 1000000001;
            long temp_steps = 0;
            boolean continue_travel = false;
            if (direction[i] == 'E') {
                for (int j = 0; j < n; j++) { //iterates each possible other cow
                    if (direction[j] == 'N') { //if cow is facing North
                        //steps till j reaches i's y coordinates
                        long steps_y = y[i] - y[j];
                        long steps_x = x[j] - x[i];
                        //if j does not pass by any of i's path at all
                        if (steps_x < 0 || steps_y < 0) { continue_travel = true; }
                        //if both move onto same cell at intersection or
                        //i reaches intersection point before j
                        else if (steps_x <= steps_y) { continue_travel = true; }
                        //if i reaches intersection point after j
                        else {
                            for (int k = 0; k < n; k++) { //if j stops before intersecting i
                                long temp_steps_y = y[k] - y[j];
                                long temp_steps_x = x[j] - x[k];
                                if (direction[k] == 'E' && k != i && temp_steps_x < temp_steps_y && y[k] < y[i] && x[k] < x[j] && x[k] > x[i]) {
                                    continue_travel = true;
                                    break;
                                }
                                else {
                                    temp_steps = steps_x;
                                    continue_travel = false;
                                }
                            }
                        }
                        if (!continue_travel) {
                            if (temp_steps < min_steps) { min_steps = temp_steps; }
                        }
                    }
                }
            }
            else { //direction is north
                for (int j = 0; j < n; j++) { //iterates each possible other cow
                    if (direction[j] == 'E') { //if cow is facing East
                        //steps till j reaches i's y coordinates
                        long steps_y = y[j] - y[i];
                        long steps_x = x[i] - x[j];
                        //if j does not pass by any of i's path at all
                        if (steps_x < 0 || steps_y < 0) { continue_travel = true; }
                        //if both move onto same cell at intersection or
                        //i reaches intersection point before j
                        else if (steps_x >= steps_y) { continue_travel = true; }
                        //if i reaches intersection point after j
                        else {
                            for (int k = 0; k < n; k++) { //if j stops before intersecting i
                                long temp_steps_y = y[j] - y[k];
                                long temp_steps_x = x[k] - x[j];
                                if (direction[k] == 'N' && k != i && temp_steps_x > temp_steps_y && y[k] > y[i] && x[k] < x[i] && y[k] < y[j]) {
                                    continue_travel = true;
                                    break;
                                }
                                else {
                                    temp_steps = steps_y;
                                    continue_travel = false;
                                }
                            }
                        }
                        if (!continue_travel) {
                            if (temp_steps < min_steps) { min_steps = temp_steps; }
                        }
                    }
                }
            }
            //print statement
            if (min_steps == 1000000001) //if none cows intersect current cow
                System.out.println("Infinity");
            else
                System.out.println(min_steps);
        }
    }
}
