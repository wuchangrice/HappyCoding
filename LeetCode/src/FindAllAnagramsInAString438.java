import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.
 */
public class FindAllAnagramsInAString438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int matchTarget = p.length();
        Map<Character,Integer> pMap = new HashMap<>();
        for(int i =0; i < matchTarget; i++){
            pMap.put(p.charAt(i), null == pMap.get(p.charAt(i)) ? 1 : pMap.get(p.charAt(i)) + 1);
        }
        int startIndex = 0;
        boolean addFlag = false;
        for(int i = 0; i < s.length(); i++) {
            if(addFlag){
                if(!pMap.containsKey(s.charAt(i))){
                    addFlag = false;
                    result.addAll(findAnagrams(startIndex, i, s, new HashMap<>(pMap), p.length()));
                }
            }else{
                if(pMap.containsKey(s.charAt(i))){
                    addFlag = true;
                    startIndex = i;
                }
            }
        }
        if(addFlag)
            result.addAll(findAnagrams(startIndex, s.length(), s, new HashMap<>(pMap), p.length()));
        return result;
    }

    /**
     * s contains all chare
     * @param startIndex
     * @param endIndex
     * @param s
     * @param pMap
     * @return
     */
    private List<Integer> findAnagrams(int startIndex, int endIndex, String s, Map<Character,Integer> pMap, final int matchTarget){
        int matchCount = 0;
        List<Integer> result = new ArrayList<>();
        //todo result.addAll(null) => null pointer exception
        if(endIndex - startIndex < matchTarget)
            return result;
        int i = startIndex;
        //todo while forget i++
        while(endIndex - i >= matchTarget - matchCount  && i < endIndex){
            int charNeed = pMap.get(s.charAt(i));
            if(charNeed > 0){
                pMap.put(s.charAt(i), charNeed -1);
                matchCount++;
                i++;
                continue;
            }
            if(matchCount == matchTarget) {
                result.add(startIndex);
            }
            int j = startIndex;
            while(s.charAt(j) != s.charAt(i)){
                pMap.put(s.charAt(j), pMap.get(s.charAt(j)) + 1);
                matchCount--;
                j++;
            }
            startIndex = j + 1;
            i++;
        }
        if(matchCount == matchTarget)
            result.add(startIndex);
        return result;
    }

}
