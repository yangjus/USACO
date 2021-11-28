import java.util.*;
import java.io.*;

public class YourRideIsHere {
    public static void main (String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("C:\\Users\\Justin\\IdeaProjects\\TrainUSACO\\src\\ride.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Justin\\IdeaProjects\\TrainUSACO\\src\\ride.out")));
        Scanner sc = new Scanner(new FileReader("ride.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String line1 = sc.next();
        String line2 = sc.next();

        char[] first = line1.toCharArray();
        char[] second = line2.toCharArray();

        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                            'W', 'X', 'Y', 'Z'};
        HashMap<Character, Integer> values = new HashMap<Character, Integer>();
        for (int i = 1; i <= 26; i++) {
            values.put(alphabet[i - 1], i);
        }
        int product1 = values.get(first[0]);
        int product2 = values.get(second[0]);
        for (int i = 1; i < first.length; i++) {
            product1 *= values.get(first[i]);
            product2 *= values.get(second[i]);
        }
        product1 = product1 % 47;
        product2 = product2 % 47;
        if (product1 == product2)
            pw.println("GO");
        else
            pw.println("STAY");

        pw.close();
    }
}
