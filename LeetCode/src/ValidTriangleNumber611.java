import Common.ArraySort;
/**
 * Created by oukinsei on 17/6/13.
 */
public class ValidTriangleNumber611 {
    public int triangleNumber(int[] nums) {
        new ArraySort().arraySort(nums);
        int result = 0;
        int arrayLength = nums.length;
        if(nums.length < 3)
            return result;
        for(int sideShort = 0; sideShort < arrayLength - 2; sideShort++) {
            for (int sideMiddle = sideShort + 1; sideMiddle < arrayLength - 1; sideMiddle++) {
                for (int sideLarge = sideMiddle + 1; sideLarge < arrayLength; sideLarge++) {
                    if (nums[sideShort] + nums[sideMiddle] > nums[sideLarge]) {
                        result++;
                        continue;
                    }
                    if (nums[sideShort] + nums[sideMiddle] <= nums[sideLarge]) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
