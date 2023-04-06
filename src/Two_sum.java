import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/?orderBy=most_votes
public class Two_sum {
    public static void main(String[] args) {
        int[] a = {2,7,13,16};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(a, target)));
        System.out.println(Arrays.toString(twoSumB(a, target)));
        System.out.println(Arrays.toString(twoSum0(a,target)));
    }
    //Brute Force Method;
    /*
    Time complexity : O(n^2 )
    space complexity : O(1);
     */
    public static int[] twoSum(int[] array, int target){
        int[] result = new int[2];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(i == j) continue;
                if(array[i] + array[j] == target){
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        return result;
    }

    //Better Force Method;
    /*
    Time complexity : O(n)
    space complexity : O(1);
     */
    public static int[] twoSumB(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){                    //HASHMAP SOLUTION
            int present = target - arr[i];
            if(map.containsKey(present)){
                return new int[]{map.get(present),i};
            }
            else map.put(arr[i], i);
        }
        throw new IllegalArgumentException("Not a Valid Sum");
    }

    //Optimal Force Method;
    /*
    Time complexity : O(n) + o(nlogn)
    space complexity : O(1);
     */
    public static int[] twoSum0(int[] arr, int target){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        while (i < j){
            if(arr[i] + arr[j] == target) {
                return new int[] {i, j};
            }
            else if(arr[i] + arr[j] > target) j--;
            else i++;
        }
        throw new IllegalArgumentException("Not A Valid Sum!!");
    }
}
