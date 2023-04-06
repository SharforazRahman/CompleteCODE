import java.util.HashMap;

public class majorityElement {
    public static void main(String[] args) {
        int[] num = {3, 2, 3};
        System.out.println(majorityElementBrute(num));
        System.out.println(majorityElementBetter(num));
        System.out.println(majorityElementOptimal(num));
    }


    //Brute Force Method;
    /*
    Time complexity : O(n^2)
    space complexity : O(1);
     */
    public static int majorityElementBrute(int[] a) {
        for (int k : a) {
            int count = 0;
            for (int i : a) {
                if (k == i) count++;
            }
            if (count > a.length / 2) return k;
        }
        return -1;
    }

    //Better Method;
    /*
    Time complexity : O(NlogN) + o(n);
    space complexity : O(n);
     */
    public static int majorityElementBetter(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : a) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i : map.keySet()) {
            if (map.get(i) > a.length / 3) return i;
        }
        return -1;
    }


    //Optimal Method;
    /*
    Time complexity : O(n);
    space complexity : O(1);
     */
    public static int majorityElementOptimal(int[] a) {
        int count = 0, element = 0;
        for (int j : a) {
            if (count == 0) {
                count = 1;
                element = j;
            } else if (j == element) count++;
            else count--;
        }
        int checkCount = 0;
        for (int j : a) {
            if (j == element) checkCount++;
        }
        return checkCount > (a.length / 2) ? element : -1;
    }
}