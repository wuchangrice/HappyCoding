package Common;

/**
 * Created by oukinsei on 17/6/9.
 */
public class ArraySort {
    public void arraySort(int[] nums){
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

    public void arrayChange(int[] nums, int pos1, int pos2){
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
