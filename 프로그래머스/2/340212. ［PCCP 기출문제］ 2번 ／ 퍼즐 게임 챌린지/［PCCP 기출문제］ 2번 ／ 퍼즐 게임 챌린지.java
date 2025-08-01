class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return binarySearch(diffs, times, limit);
    }
    
    public int binarySearch(int[] diffs, int[] times, long limit) {
        int max = 1;
        int min = 100000;
        
        while (max <= min) {
            int level = (max + min) / 2;
            long total = calc(diffs, times, level);
            
            if (total > limit) max = level + 1;
            else min = level - 1;
        }
        return max;
    }
    
    public long calc(int[] diffs, int[] times, long level) {
        long total = 0;
        for (int i=0; i<diffs.length; ++i) {
            if (diffs[i] <= level) total += times[i];
            else total += (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
        }
        return total;
    }
}