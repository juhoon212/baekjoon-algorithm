class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        return binarySearch(diffs, times, limit);
    }
    
    public int binarySearch(int[] diffs, int[] times, long limit) {
        int max = 1;
        int min = 100000;
        
        while (max <= min) {
            int level = (min + max) / 2;        
            long mid = calculate(diffs, times, level);
            
            if (mid > limit) max = level + 1;
            else min = level - 1;
        }
        
        return max;
    }
    
    public long calculate(int[] diffs, int[] times, int level) {
        long cur = 0;
        for (int i=0; i<diffs.length; ++i) {
            if (diffs[i] <= level) cur += times[i];
            else {
                cur += (long)(times[i - 1] + times[i]) * (long)(diffs[i] - level) + times[i];
            }
        }
        return cur;
    }
}