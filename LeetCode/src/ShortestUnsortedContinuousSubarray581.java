/**
 * Created by oukinsei on 17/6/15.
 */
public class ShortestUnsortedContinuousSubarray581 {
    /**
     * 思路：找到排序是第一个需要交换和最后一个需要交换元素的位置，两者之差
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        while (first < last) {
            if (nums[first] <= nums[first + 1])
                first++;
        }
        if (first == last) {
            return 0;
        }

        while (last > first) {
            if (nums[last] >= nums[last - 1])
                last--;
        }

        first = (first == 0) ? first : (first - 1);
        last = (last == nums.length -1 ) ? last : (last + 1);

        int minValue = nums[0], maxValue = nums[0];
        //find maxVale & minValue from first to last
        for (int i = first; i <= last; i++) {
            if (minValue > nums[i]) {
                minValue = nums[i];
                continue;
            }
            if (maxValue < nums[i]) {
                maxValue = nums[i];
                continue;
            }
        }

        for(int i = 0; i <= first; i++){
            if (nums[i] > minValue){
                first = i;
                break;
            }
        }

        for(int i = nums.length; i >= last; i++){
            if (nums[i] < maxValue){
                last = i;
                break;
            }
        }

        return last - first + 1;
    }

}
