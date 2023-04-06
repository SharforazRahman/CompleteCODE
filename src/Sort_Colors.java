import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/description/?orderBy=most_votes
public class Sort_Colors {
    public static void main(String[] args) {
        int[] num = {2, 0, 2};
        sortColorBrute(num);
        sortColorBetter(num);
    }

    //Brute Method;
    /*
    Time complexity : O(NlogN);
    space complexity : O(1);
     */
    public static void sortColorBrute(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //Better Method;
    /*
    Time complexity : O(2N);
    space complexity : O(1);
     */
    public static void sortColorBetter(int[] arr) {
        int zero = 0, one = 0, two = 0;

        for (int i : arr) {
            if (i == 0) zero++;
            else if (i == 1) one++;
            else two++;
        }
        for (int i = 0; i < zero; i++) arr[i] = 0;
        for (int i = zero; i < zero + one; i++) arr[i] = 1;
        for (int i = zero + one; i < arr.length; i++) arr[i] = 2;

        System.out.println(Arrays.toString(arr));
    }
}
