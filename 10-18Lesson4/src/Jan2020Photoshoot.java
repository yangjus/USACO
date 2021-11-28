import java.util.*;
import java.io.*;

public class Jan2020Photoshoot {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        int n = sc.nextInt();
        int[] b = new int[n-1];
        boolean valid = false;
        for (int i = 0; i < n-1; i++) {
            b[i] = sc.nextInt();
            //System.out.println(b[i]);
        }
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < b[0]; i++) {    //create possible permutation
            a.add(b[0] - i); //a1
            a.add(i);    //a2
            int temp = i;
            for (int j = 1; j < n-1; j++) { //loops a[i] = b[i-1] - a[i-1]
                temp = b[j] - temp;
                a.add(temp); //a3 to aN
            }

            for (int element : a) { //find and print valid permutation
                if (element > n || element < 1 || findRepeating(a)) { //if not satisfy conditions
                    valid = false;
                    break;
                }
                valid = true;
            }
            if (valid) {
                for (int num : a) {
                    if (num == a.get(0))    //so no whitespace at the end
                        pw.print(num);
                    else
                        pw.print(" " + num);
                }
                break;
            }
            a.clear();  //reset list for next possible permutation
        }
        pw.close();
    }
    public static boolean findRepeating(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = list.size()-1; i >= 0; i--) {
            if (set.contains(list.get(i)))  //if set has the number
                return true;
            else
                set.add(list.get(i));   //set adds the number
        }
        return false;
    }
}
