package Common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czhang on 8/31/17.
 */
public class bfs {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> lastList = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        lastList.add(beginWord);
        int result = 0;
        while(true){
            result++;
            if(lastList.isEmpty())
                return 0;
            for(String last:lastList){
                int i= 0;
                int length = wordList.size();
                while(i < length){
                    String current = wordList.get(i);
                    if(canChange(last,current)){
                        if(current.equals(endWord)){
                            return result;
                        }
                        currentList.add(current);
                        wordList.remove(current);
                        i--;
                        length--;
                    }
                    i++;
                }
            }
            lastList = currentList;
        }

    }

    private boolean canChange(String a, String b){
        int diff = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                diff++;
        }
        return diff < 2;
    }
}
