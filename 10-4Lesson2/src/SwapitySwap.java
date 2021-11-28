import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class SwapitySwap {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("swap.in");
        Scanner sc = new Scanner(inputFile);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));

        //Store variables
        int[] variables = new int[6];   //[N, K, A1, A2, B1, B2]
        for (int i=0; i<6; i++) {
            variables[i] = sc.nextInt();
            //System.out.println(variables[i]);
        }
        //Make ArrayList of cows
        int[] cowArray = new int[variables[0]];
        for (int i = 0; i < variables[0]; i++)
            cowArray[i] = i;
        //System.out.println(Arrays.toString(cowArray));

        //Reverse
        int cycleSize = 0;  //how many cycles before original order repeats
        boolean sorted = true;
        do {
            cycleSize++;
            reverse(cowArray, variables[2], variables[3]);
            reverse(cowArray, variables[4], variables[5]);
            sorted = true; //reset boolean
            for(int i = 0; sorted && i < variables[0]; i++) //keep looping until order repeats
                sorted = (cowArray[i] == i);  //if cowArray[i] != i, sorted = false (order not repeat yet)
        } while(!sorted);   //when sorted = true, stop looping

        variables[1] %= cycleSize;  //find remainder after dividing by number of repeated cycles
        for (int i = 0; i < variables[0]; i++)  //refresh cowArray back to original array
            cowArray[i] = i + 1;
        for (int i = 0; i < variables[1]; i++) {    //reverse the remainder of non-repeating cycles
            reverse(cowArray, variables[2], variables[3]);
            reverse(cowArray, variables[4], variables[5]);
        }
        //Output
        for (int item : cowArray) {
            System.out.println(item);
            pw.println(item);
        }
        pw.close();
    }

    private static void reverse(int[] l, int a, int b) {
        while (a < b) { //keeps reversing until midpoint, because after that is redundant
            int t = l[a-1]; //temp variable t to store first value
            l[a-1] = l[b-1];    //first value becomes the other value
            l[b-1] = t; //the other value becomes the first value through temp variable t
            a++;    //gets closer to midpoint
            b--;    //gets closer to midpoint
        }
    }
}
