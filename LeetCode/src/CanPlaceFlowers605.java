/**
 * Created by oukinsei on 17/6/14.
 */
public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int currentLength = 0;
        int result = 0;
        for(int i = 0; i < flowerbed.length;i++){
            if(flowerbed[i] == 1){
                currentLength--;
                result += lengthCanPlantCount(currentLength);
                currentLength = 0;
                i++;
            }else{
                currentLength++;
            }
        }
        result += lengthCanPlantCount(currentLength);
        return n <= result;
    }
    public int lengthCanPlantCount(int length){
        if(length < 1)
            return 0;
        return (length + 1) / 2;
    }
}
