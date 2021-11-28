import java.util.*;

public class HashMapFrequency {
    public static void main(String[] args) {
        //Finding most frequently occurred element in an array
        int[] array = {1,2,3,4,5,5,6,7,8,8,8,9,10};	//output 8 here
        HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();	//<key, value>
        for (int element : array) {	//traverse array
            if (myMap.containsKey(element))	//if the element is a key
            myMap.put(element, myMap.get(element)+1);	//+1 value to the key
            else
            myMap.put(element, 1);
        }
        int maxFreq = -1;	//makes sure it is smaller than any frequency
        int keyOfMaxFreq = -1;
        for (HashMap.Entry mapElement : myMap.entrySet()) {	//traverses the keys in hashmap
            int key = (int)mapElement.getKey();
            int value = (int)mapElement.getValue();
            if (value > maxFreq) {
                maxFreq = value;
                keyOfMaxFreq = key;
            }
        }
        //finding second max value
        int secondMaxFreq = -1;
        int keyOfSecondMaxFreq = -1;
        for (HashMap.Entry mapElement : myMap.entrySet()) {	//traverses the keys in hashmap
            int key = (int)mapElement.getKey();
            int value = (int)mapElement.getValue();
            if (value > secondMaxFreq && value < maxFreq) {	//if it is not max, then must be second max
                secondMaxFreq = value;
                keyOfSecondMaxFreq = key;
            }
        }
        System.out.println(secondMaxFreq);
        System.out.println(keyOfSecondMaxFreq);
    }
}
