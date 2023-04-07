//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

import java.util.ArrayList;

public class LeaderInArray {
    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        replaceElementsBrute(arr);
        replaceElementsOptimal(arr);
    }


    //Brute Method;
    /*
    Time complexity : O(N^2);
    space complexity : O(n);
     */
    public static void replaceElementsBrute(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) list.add(arr[i]);
        }
        System.out.println(list);
    }

    //Optimal Method;
    /*
    Time complexity : O(N);
    space complexity : O(n);
     */
    public static void replaceElementsOptimal(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                list.add(arr[i]);
            }
            max = Math.max(max, arr[i]);
        }

        System.out.println(list);
    }
}
