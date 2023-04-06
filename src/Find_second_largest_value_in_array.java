import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/second-largest3735/1
public class Find_second_largest_value_in_array {
    public static void main(String[] args) {
        int[] Arr = {1, 2, 4, 7, 7, 5};
        System.out.println(findSecondMax(Arr));
        System.out.println(findSecondMaxB(Arr));
        System.out.println(findSecondMaxO(Arr));
    }

    //Brute Force Method;
    /*
    Time complexity : O(n+nlogn)
    space complexity : O(1);
     */
    public static int findSecondMax(int[] array) {
        Arrays.sort(array); // O(n(logn))
        int max = array[array.length - 1];

        //O(n)
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] != max) return max = array[i];
        }
        return -1;
    }

    //Better Solution
    /*
    Time complexity : O(2n)
    Space complexity: O(1)
     */

    public static int findSecondMaxB(int[] arr) {
        int max = 0, secondLargest = -1;
        for (int i : arr) max = Math.max(max, i); //O(n);
        for (int i : arr) {
            if (i > secondLargest && i != max) secondLargest = i; //O(n)
        }
        return secondLargest;
    }

    public static int findSecondMaxO(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;

        for (int j : arr) {
            if (j == largest) continue;
            if (j > largest) {
                secondLargest = largest;
                largest = j;
            }
            else if(j > secondLargest){
                secondLargest = j;
            }
        }
        return secondLargest;
    }
}
