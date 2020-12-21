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
            //each index increment is one more hay bale, thus upperIndex - lowerIndex
            count = upperIndex(arr, n, upperbound) - lowerIndex(arr, n, lowerbound) + 1;
            pw.println(count);
        }
        pw.close();
    }

    public static int lowerIndex(long arr[], int n, long x) {
        int l = 0; //lowerbound of temp range
        int h = n - 1; //upperbound of temp range
        while (l <= h){ //keep iterating until lowest index >= LB of query is found
            int mid = (l + h) / 2;
            if (arr[mid] >= x) //if the middle element of temp range >= LB of query
                h = mid - 1; //new temp range is lower half of old temp range
            else
                l = mid + 1; //else temp range is upper half of old temp range
        }
        return l; //return lowest index
    }

    public static int upperIndex(long arr[], int n, long y) {
        int l = 0;
        int h = n - 1;
        while (l <= h){ //keep iterating until highest index >= UB of query is found
            int mid = (l + h) / 2;
            if (arr[mid] <= y) //if the middle element of temp range <= UB of query
                l = mid + 1; //new temp range is upper half of old temp range
            else
                h = mid - 1; //else temp range is lower half of old temp range
        }
        return h; //return highest index
    }
}
