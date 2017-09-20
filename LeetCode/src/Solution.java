import java.util.ArrayList;
import java.util.List;

/**
 * Created by czhang on 8/8/17.
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=nums.length;i++){
            if(nums[i-1] == 0){
                continue;
            }
            int start = nums[i-1];
            nums[i-1] = -1;
            while(true){
                if(nums[start-1] == start){
                    nums[start-1] = 0;
                    result.add(start);
                    break;
                }
                if(nums[start-1] == -1){
                    nums[start-1] = 0;
                    break;
                }
                if(nums[start-1] == 0){
                    result.add(start);
                    break;
                }
                int oldStart = start;
                start = nums[start-1];
                nums[oldStart-1] = 0;
            }
        }
        return result;
    }
}
