import Common.ArraySort;

/**
 * Created by oukinsei on 17/6/9.
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        if (nums.length < 1)
            return result;
        new ArraySort().arraySort(nums);
        int i = 0;
        while (i < nums.length){
            result += nums[i];
            i = i + 2;
        }
        return result;
    }
}
