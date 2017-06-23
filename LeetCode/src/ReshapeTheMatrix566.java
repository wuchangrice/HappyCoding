/**
 * Created by oukinsei on 17/6/23.
 * 注意事项：
 * 1.边界值，newC < c - 1
 * 2.int[][]行列的求法
 */
public class ReshapeTheMatrix566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int originR = nums.length;
        int originC = nums[0].length;
        if(originR * originC != r * c){
            return nums;
        }
        int[][] result = new int[r][c];
        int newR = 0, newC = 0;
        for(int i = 0; i < originR; i++){
            for(int j = 0; j < originC; j++){
                result[newR][newC] = nums[i][j];
                if(newC < c - 1){
                    newC++;
                }else{
                    newR++;
                    newC = 0;
                }
            }
        }
        return result;
    }
}
