//https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/0
public class Find_largest_value_in_array {
    public static void main(String[] args) {
        int[] A = {1, 8, 7, 56, 90};
        System.out.println(findMaximum(A));
    }

    public static int findMaximum(int[] array){
        int max = 0;
        for(int i : array) max = Math.max(max,i);
        return max;
    }
}
