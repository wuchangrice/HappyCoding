import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by oukinsei on 17/8/7.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstringSet(String s) {
        if(null == s) return 0;
        int result = 0, start = 0;
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(charSet.contains(s.charAt(i))){
                result = maxInt(result, charSet.size());
                for(int j = start; j <= i; j++){
                    if(s.charAt(j) == s.charAt(i)){
                        start = j + 1;
                        break;
                    }
                    charSet.remove(s.charAt(j));
                }
            }else{
                charSet.add(s.charAt(i));
            }
        }
        //last compare
        return maxInt(result, charSet.size());
    }
    public int lengthOfLongestSubstring(String s) {
        if(null == s) return 0;
        int result = 0, start = -1;
        Map<Character,Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(charMap.containsKey(s.charAt(i))){
                start = maxInt(start, charMap.get(s.charAt(i)));
            }
            charMap.put(s.charAt(i), i);
            result = maxInt(result, i - start);
        }
        return result;
    }
    private int maxInt(int a, int b){
        return a > b ? a : b;
    }
}
