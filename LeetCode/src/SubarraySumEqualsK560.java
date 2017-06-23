import java.util.*;

/**
 * Created by oukinsei on 17/6/15.
 */
public class SubarraySumEqualsK560 {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k)
                result++;
            result += getMap(map, sum);
            insertMap(map, sum + k);
        }
        return result;
    }
    private void insertMap(Map<Integer,Integer> map, int i){
        if(map.containsKey(i)){
            map.put(i, map.get(i) + 1);
        }else{
            map.put(i, 1);
        }
    }
    private int getMap(Map<Integer,Integer> map, int i){
        if(map.containsKey(i)){
            return map.get(i);
        }else{
            return 0;
        }
    }
}
