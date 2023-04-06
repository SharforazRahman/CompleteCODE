//https://leetcode.com/problems/single-number/
import java.util.HashMap;

public class singleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4};
        System.out.println(NumberAppearedOnceBrute(arr));
        System.out.println(NumberAppearedOnceBetter(arr));
        System.out.println(NumberAppearedOnceOptimal(arr));
    }

    //Brute Method;
    /*
    Time complexity : O(N^2);
    space complexity : O(1);
     */
    public static int NumberAppearedOnceBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) continue;
                else return arr[j];
            }
        }
        return -1;
    }


    //Better Method;
    /*
    Time complexity : O(N);
    space complexity : O(N);
     */
    public static int NumberAppearedOnceBetter(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : map.keySet()) {
            if (map.get(i) == 1) return i;
        }
        return -1;
    }

    //Optimal Method;
    /*
    Time complexity : O(N);
    space complexity : O(1);
     */
    public static int NumberAppearedOnceOptimal(int[] arr) {
        int xor = 0;
        for(int i : arr){
            xor ^= i;
        }
        return xor;
    }
}
