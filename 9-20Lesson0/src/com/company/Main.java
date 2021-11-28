package com.company;

import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\Justin\\IdeaProjects\\9-20Lesson0\\src\\ReadFile");
        Scanner sc = new Scanner(inputFile);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
                "C:\\Users\\Justin\\IdeaProjects\\9-20Lesson0\\src\\fileoutput.out")));
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3 = sc.nextInt();
            if (num1 + num2 + num3 == 20) {
                pw.println(num1 + " " + num2 + " " + num3);
            }
        }
        pw.close();
    }
}
