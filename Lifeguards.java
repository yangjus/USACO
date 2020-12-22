/*
January 2018 Silver Problem: Lifeguards
Solved and Modified: Justin Y
Custom Comparators from: https://usaco.guide/silver/sorting-custom/#c
*/
import java.util.*;
import java.io.*;

public class Lifeguards {
    static class Start implements Comparable<Start>{
        long s,e;
        public Start (long _s, long _e) {
            s = _s; e = _e;
        }
        public int compareTo(Start x) {
            //compare self start point with another start point
            return Long.compare(s, x.s);
        }
    }

    public static void main (String[] args) throws IOException{
        //Scanner sc = new Scanner(new File("/Users/kat/Desktop/Justin/USACO/src/lifeguards.in"));
        Scanner sc = new Scanner(new File("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        int n = sc.nextInt();
        ArrayList<Start> list = new ArrayList<Start>();
        for (int i = 0; i < n; i++) {
            long s = sc.nextLong();
            long e = sc.nextLong();
            list.add(new Start(s,e));
        }
        //sort arrayList based on start points
        //using Custom Comparators to sort specified value of each cow in arrayList
        Collections.sort(list);

        long max = 0;
        for (int i = 0; i < n; i++) { //iterate through each removed-cow scenario
            long possible_max = 0;
            long start = 0;
            long end = 0;
            if (i == 0) {
                start = list.get(1).s;
                end = list.get(1).e;
            }
            else {
                start = list.get(0).s;
                end = list.get(0).e;
            }
            for (int j = 0; j < n; j++) { //iterate through the scenario
                if (list.get(j) != list.get(i)) {
                    if (list.get(j).s > end) {
                        possible_max += end - start;
                        start = list.get(j).s;
                    }
                    end = list.get(j).e;
                    //if at last iteration
                    if (j == n-1 && (list.get(j).s <= end)) {
                        possible_max += end - start;
                    }
                }
            }
            if (possible_max > max) { max = possible_max; }
        }
        //System.out.println(max);
        pw.println(max);
        pw.close();
    }

    //test Sort method by printing Start object list
    public static void printList(ArrayList<Start> list) {
        for (Start e : list) {
            System.out.println(e.s + " " + e.e);
        }
    }
}