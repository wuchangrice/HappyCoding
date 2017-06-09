/**
 * Created by oukinsei on 17/6/9.
 */
public class ArraySort {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        if (nums.length < 1)
            return result;
        arraySort(nums);
        int i = 0;
        while (i < nums.length){
            result += nums[i];
            i = i + 2;
        }
        return result;
    }
    private void arraySort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int minPos = i;
            int minValue = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (minValue > nums[j]){
                    minPos = j;
                    minValue = nums[j];
                }
            }
            arrayChange(nums, i, minPos);
        }
    }

    private void arrayChange(int[] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
