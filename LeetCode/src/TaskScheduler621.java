/**
 * Created by oukinsei on 17/7/3.
 * 1.maxDuplicateDuplicate这个命名很差
 *
 */
public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        int[] statistics = new int[26];
        for(int i = 0; i < tasks.length; i++){
            int position = tasks[i] - 'A';
            statistics[position]++;
        }
        int maxDuplicate = 0;
        int maxDuplicateDuplicate = 0;
        for(int i = 0; i < statistics.length; i++){
            if (statistics[i] > maxDuplicate) {
                maxDuplicate = statistics[i];
                maxDuplicateDuplicate = 1;
            } else if (statistics[i] == maxDuplicate){
                maxDuplicateDuplicate++;
            }
        }
        int result1 = (maxDuplicate - 1) * (n + 1) + maxDuplicateDuplicate;
        return (result1 > tasks.length) ? result1 : tasks.length;
    }
}
