import java.util.*;
import java.io.*;

public class JanuaryLifeguards {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\lifeguards.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\USACOBronze2018\\src\\lifeguards.out")));
        Scanner sc = new Scanner(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        //Use Bubble Sort implementation to sort start[] and corresponding end[]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (start[i] > start[j]) {
                    int tempStart = start[i];
                    int tempEnd = end[i];
                    start[i] = start[j];
                    end[i] = end[j];
                    start[j] = tempStart;
                    end[j] = tempEnd;
                }
            }
        }

        int max_time_covered = 0;
        for (int j = 0; j < n; j++) { //iterate for each fired cow combination
            int[] modified_start = removeElement(start, j); //remove the fired cow
            int[] modified_end = removeElement(end, j);
            int min = modified_start[0];
            int max = modified_end[0];
            int counter = 0; //reset for each cow combination iteration
            for (int i = 1; i < n-1; i++) { //iterate each cow
                if (modified_start[i] < max && modified_end[i] > max) {
                    //keep adding to end of interval when overlap
                    max = modified_end[i];
                }
                else { //when no more overlap, make new interval
                    counter += (max - min);
                    min = modified_start[i];
                    max = modified_end[i];
                }
            }
            counter += (max - min); //for last interval
            if (counter > max_time_covered) { //find max amount of time
                max_time_covered = counter;
            }
        }
        System.out.println(max_time_covered);
        pw.println(max_time_covered);
        pw.close();
    }

    public static int[] removeElement(int[] arr, int index) {
        int[] removed_element_Array = new int[arr.length - 1];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                removed_element_Array[counter] = arr[i];
                counter++;
            }
        }
        return removed_element_Array;
    }
}
