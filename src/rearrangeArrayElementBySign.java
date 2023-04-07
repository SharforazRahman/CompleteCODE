import java.util.ArrayList;
import java.util.Arrays;

public class rearrangeArrayElementBySign {
    public static void main(String[] args) {
        int[] arr = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeBrute(arr)));
        System.out.println(Arrays.toString(rearrangeOptimal(arr)));
    }

    //Brute Force Method;
    /*
    Time complexity : O(n^2)
    space complexity : O(1);
     */
    public static int[] rearrangeBrute(int[] arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int i : arr) {
            if (i > 0) positive.add(i);
            else negative.add(i);
        }
        for (int p = 0, n = 1, l = 0; p < arr.length - 1; p += 2, n += 2, l++) {
            arr[p] = positive.get(l);
            arr[n] = negative.get(l);
        }
        return arr;
    }

    public static int[] rearrangeOptimal(int[] arr) {
        int[] res = new int[arr.length];
        int positive = 0, negative = 1;

        for (int j : arr) {
            if (j < 0) {
                res[negative] = j;
                negative += 2;
            } else {
                res[positive] = j;
                positive += 2;
            }
        }
        return res;
    }
}
