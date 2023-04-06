//https://leetcode.com/problems/max-consecutive-ones/
public class maximum_Consecutive_Ones {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println(maxOnesOptimal(arr));
    }

    //Optimal Method;
    /*
    Time complexity : O(N);
    space complexity : O(1);
     */
    public static int maxOnesOptimal(int[] arr) {
        int count = 0, max = 0;
        for (int j : arr) {
            if (j == 1) count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }
}
