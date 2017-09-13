import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oukinsei on 9/13/17.
 */
public class UnionFindSetsAmazon {

    public Map<Integer,List<String>> unionFindSets(List<Relation> relations){
        Map<Integer,List<String>> result = new HashMap<>();
        Map<String, Integer> keyGroup = new HashMap<>();
        int i = 0;
        for(Relation relation:relations){
            if(!keyGroup.containsKey(relation.x) && !keyGroup.containsKey(relation.y)){
                keyGroup.put(relation.x, i);
                keyGroup.put(relation.y, i);
                List<String> items = new ArrayList<>();
                items.add(relation.x);
                items.add(relation.y);
                result.put(i, items);
                i++;
            }else if(keyGroup.containsKey(relation.x) && keyGroup.containsKey(relation.y)){
                int value1 = keyGroup.get(relation.x);
                int value2 = keyGroup.get(relation.y);
                if(value1 != value2) {
                    union(keyGroup, result, value1, value2);
                }
            }else{
                Integer value1 = keyGroup.get(relation.x);
                Integer value2 = keyGroup.get(relation.y);
                if(null == value2){
                    keyGroup.put(relation.y, value1);
                    result.get(value1).add(relation.y);
                }else{
                    keyGroup.put(relation.x, value2);
                    result.get(value2).add(relation.x);
                }
            }
        }

        return result;
    }


    private void union(Map<String, Integer> keyValue, Map<Integer,List<String>> valueKey, int value1, int value2){
        List<String> keys = valueKey.get(value2);
        for(String key:keys){
            keyValue.put(key,value1);
        }
        keys.addAll(valueKey.get(value1));
        valueKey.put(value1, keys);
        valueKey.put(value2, new ArrayList<>());
    }
}
