//https://leetcode.com/problems/missing-number/
import java.util.HashMap;

public class Missing_Number {
    public static void main(String[] args) {
        int[] num = {1, 2, 4, 5};
        System.out.println(missingNumberBrute(num));
        System.out.println(missingNumberBetter(num));
        System.out.println(missingNumberOptimal(num));
    }

    //Brute Method;
    /*
    Time complexity : O(N^2);
    space complexity : O(1);
     */
    public static int missingNumberBrute(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - 1; j++) {
                if (i == arr[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;
        }
        return -1;
    }

    //Better Method;
    /*
    Time complexity : O(N) + O(N);
    space complexity : O(N);
     */
    public static int missingNumberBetter(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, j);
        }
        for(int i = 1; i <= arr.length; i++){
            if(!map.containsKey(i)) return i;
        }
        return -1;
    }

    //Optimal Method;
    /*
    Time complexity : O(N);
    space complexity : O(1);
     */
    public static int missingNumberOptimal(int[] arr) {
        int len = arr.length + 1; // Because one number is missing, so the main length is a.length + 1;
        int sum = (len * (len + 1)) / 2;
        int store = 0;

        for (int j : arr) {
            store += j;
        }
        return sum - store;
    }
}
