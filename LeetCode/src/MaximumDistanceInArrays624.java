import java.util.List;

/**
 * Created by oukinsei on 17/7/4.
 * 1.无脑复制极有可能带入bug
 * 2.特殊处理list(0),并不是一个好的方法。如何处理min和max的初始值
 * 3.
 */
public class MaximumDistanceInArrays624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int min = 10000;
        int max = -10000;
        for(int i = 0; i < arrays.size(); i++){
            List<Integer> list = arrays.get(i);
            result = (result < (max - list.get(0))) ? (max - list.get(0)) : result;
            result = (result < (list.get(list.size() - 1) - min)) ? (list.get(list.size() - 1) - min) : result;
            if (list.get(0) < min)
                min = list.get(0);
            if (list.get(list.size() - 1) > max)
                max = list.get(list.size() - 1);
        }
        return result;
    }
}
