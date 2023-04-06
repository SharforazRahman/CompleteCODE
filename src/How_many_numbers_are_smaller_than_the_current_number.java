import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class How_many_numbers_are_smaller_than_the_current_number {
    public static void main(String[] args) {
        int[] num = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrentO(num)));
    }

    //Brute Force Method;
    /*
    Time complexity : O(n^2)
    space complexity : O(1);
     */
    public int[] smallerNumbersThanCurrent(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 0;
        for (int j : arr) {
            for (int num : arr) {
                if (j > num) {
                    count++;
                }
            }
            list.add(count);
            count = 0;
        }
        int[] new_Array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            new_Array[i] = list.get(i);
        }
        return new_Array;
    }


    //Optimal Method;
    /*
    Time complexity : O(n)
    space complexity : O(1);
     */
    public static int[] smallerNumbersThanCurrentO(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = a.clone();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], i); //use of putIfAbsent: Clearly mentioned in My Notes
        }
        System.out.println(map);
        for (int i = 0; i < a.length; i++) {
            arr[i] = map.get(a[i]);
        }
        return arr;
    }
}
