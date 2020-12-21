/*
December 2016 Silver Problem: Counting Haybales
Modified: Justin Y
Iterative Binary Search from: https://www.geeksforgeeks.org/queries-counts-array-elements-values-given-range/
*/
import java.util.*;
import java.io.*;

public class CountingHaybales {
    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(new File("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //preprocess (sort) array in O(N) time
        Arrays.sort(arr);

        for (int i = 0; i < q; i++) {
            long lowerbound = sc.nextInt();
            long upperbound = sc.nextInt();
            int count = 0;
            //Utilize iterative binary search, O(log N) time compared to
            //linear search, which is O(N) time
            count = upperIndex(arr, n, upperbound) - lowerIndex(arr, n, lowerbound) + 1;
            pw.println(count);
        }
        pw.close();
    }

    public static int lowerIndex(long arr[], int n, long x) {
        int l = 0;
        int h = n - 1;
        while (l <= h){
            int mid = (l + h) / 2;
            if (arr[mid] >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int upperIndex(long arr[], int n, long y) {
        int l = 0;
        int h = n - 1;
        while (l <= h){
            int mid = (l + h) / 2;
            if (arr[mid] <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }
}
