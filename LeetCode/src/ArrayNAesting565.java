import java.util.HashSet;
import java.util.Set;

/**
 * Created by oukinsei on 17/6/16.
 */
public class ArrayNAesting565 {
    public int arrayNesting(int[] nums) {
        Set<Integer> usedData = new HashSet<>();
        Set<Integer> currentData = new HashSet<>();
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(usedData.size() == nums.length)
                break;
            if(usedData.contains(i)){
                continue;
            }
            int j = i;
            while(canInsert(currentData, nums[j])){
                j = nums[j];
            }
            if(currentData.size() > result)
                result = currentData.size();
            currentData.clear();
        }
        return result;
    }

    private boolean canInsert(Set<Integer> set, int i){
        if(set.contains(i)){
            return false;
        }else{
            set.add(i);
            return true;
        }
    }
}
