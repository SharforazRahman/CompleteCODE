//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Remove_duplicate_from_sorted_Array {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3, 3};
        System.out.println(Arrays.toString(distinctElementBrute(array)));
        System.out.println(Arrays.toString(distinctElementOptimal(array)));
    }

    //Brute Method;
    /*
    Time complexity : O(NlogN)+N;
    space complexity : O(N);
     */
    public static int[] distinctElementBrute(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i); // Time Complexity : NlogN;

        int index = 0;
        for (int i : set){
            arr[index++] = i; // Time Complexity : O(N);
        }
        return arr;
    }

    //Optimal Method;
    /*
    Time complexity : O(N);
    space complexity : O(1);
     */
    public static int[] distinctElementOptimal(int[] a){
        if(a.length == 0) return new int[]{0};
        int i = 0;
        int j = 1;

        while (j < a.length){
            if(a[i] == a[j]) j++;
            else if(a[i] != a[j]){
                i++;
                a[i] = a[j];
            }
        }
        return a;
    }
}
