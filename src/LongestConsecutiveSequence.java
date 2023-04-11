import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveBrute(arr));
    }

    //Brute Force Method;
    /*
    Time complexity : O(n^2)
    space complexity : O(1);
     */
    public static int longestConsecutiveBrute(int[] arr) {
        int length = 1, max = 1;
        for (int j : arr) {
            int element = j;
            length = 1;
            while (search(arr, element + 1)) {
                element++;
                length++;
            }
            max = Math.max(max, length);
        }
        return max;
    }

    public static boolean search(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) return true;
        }
        return false;
    }


    //Optimal Method;
    /*
    Time complexity : O(N)+2(N) = 3(N);
    space complexity : O(1);
     */
    public static int longestConsecutiveOptimal(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);

        int max = 1, length = 1;

        //Time Complexity : O(2N)
        for (int i : arr) {
            if (!set.contains(i - 1)) {
                int ele = i;
                length = 1;
                while (set.contains(ele + 1)){
                    ele++;
                    length++;
                }
            }
            max = Math.max(max,length);
        }
        return max;
    }
}
