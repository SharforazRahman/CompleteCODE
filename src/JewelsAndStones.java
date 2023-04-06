import java.util.HashMap;

//https://leetcode.com/problems/jewels-and-stones/description/
public class JewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels,stones));
        System.out.println(numJewelsInStonesO(jewels,stones));
    }

    //Brute Force Method;
    /*
    Time complexity : O(n^2 )
    space complexity : O(1);
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i = 0; i < jewels.length(); i++){
            for(int j = 0; j < stones.length(); j++){
                if(jewels.charAt(i) == stones.charAt(j)) count++;
            }
        }
        return count;
    }

    //Optimal Force Method;
    /*
    Time complexity : O(n)
    space complexity : O(1);
     */
    public static int numJewelsInStonesO(String jewels, String stones) {
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        for(char s : stones.toCharArray()) map.put(s, map.getOrDefault(s, 0)+1);
        for(char j : jewels.toCharArray()){
            if(map.containsKey(j)) result += map.get(j);
        }
        return result;
    }
}
