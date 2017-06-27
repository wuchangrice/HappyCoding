/**
 * Created by oukinsei on 17/6/27.
 * 1.最好是子函数中不要修改参数值
 * 2.max1,max2,max3命名起的不好，都不知道谁是最大的了
 */
public class MaximumProductOfThreeNumbers628 {
    public int maximumProduct(int[] nums) {
        int[] xx = new int[2001];
        for(int i = 0; i < nums.length; i++){
            xx[(nums[i] + 1000)] += 1;
        }
        int min1 = foundNum(xx, 0, 1);
        int min2 = foundNum(xx, min1, 1);
        //需要还原
        xx[min1] += 1;
        xx[min2] += 1;
        int max1 = foundNum(xx, 2000, -1);
        int max2 = foundNum(xx, max1, -1);
        int max3 = foundNum(xx, max2, -1);
        int result1 = (min1 - 1000) * (min2 - 1000) * (max1 - 1000);
        int result2 = (max3 - 1000) * (max2 - 1000) * (max1 - 1000);
        if(result1 > result2)
            return result1;
        return result2;

    }
    private int foundNum(final int[] xx, int start, int move){
        //默认不会越界，一定能找到
        for(int i = start; ;){
            if(xx[i] > 0){
                xx[i] -= 1;
                return i;
            }
            i += move;
        }
    }
}
