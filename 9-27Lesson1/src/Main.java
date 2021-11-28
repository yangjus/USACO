import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("triangles.in");
        Scanner sc = new Scanner(inputFile);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int numPoint = sc.nextInt();	//.next() just returns a string, creates error
        int[] x = new int[numPoint];
        int[] y = new int[numPoint];
        for (int i = 0; i < numPoint; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        //printArray(x);
        //printArray(y);  //to make sure coords arrays are correct

        int maxArea = 0;

        for (int i = 0; i<numPoint-2; i++)    //finding all combinations
            for (int j = i+1; j<numPoint-1; j++) //iterates through k first, then j, then i
                for (int k = j+1; k<numPoint; k++) {
                    if ((x[i]==x[j] || x[i]==x[k] || x[j]==x[k]) &&
                            (y[i]==y[j] || y[i]==y[k] || y[j]==y[k])) { //checks valid triangle
                        int newArea = area(x[i],y[i],x[j],y[j],x[k],y[k]);
                        if (newArea > maxArea) {    //find max area
                            maxArea = newArea;
                        }
                    }
                }
        pw.println(maxArea);
        pw.close();
    }
    static void printArray(int[] array) {
        for (int item : array) {
            System.out.println(item);
        }
    }

    static int area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
    }
}
