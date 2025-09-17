class Solution {
    // n개의 퍼즐을 제한 시간 내에 풀어야함.
    // 숙련도에 따라 퍼즐을 풀 때 틀리는 횟수가 바뀜.
    // diff : 현재 퍼즐 난이도
    // 소요 시간 : time_cur
    // 이전 퍼즐 소요 시간: time_prev
    // 내 숙련도: level
    
    // diff <= level -> time_cur
    // diff > level -> diff - level 틀리고 틀릴떄마다 time_cur 만큼 시간을 사용하며, 추가로 time_prev 만큼의 시간을 사용해
    // 이전 퍼즐을 다시 풀고옴
    // 이전 퍼즐을 다시 풀때는 이전퍼즐의 난이도 상관 x
    // diff - level번 틀린 이후에 다시 퍼즐을 풀면 time_cur만큼의 시간을 사용
    public int solution(int[] diffs, int[] times, long limit) {
        // 숙련도의 최솟값 즉 level의 최솟값을 구하는 문제
        return binarySearch(diffs, times, limit);
    }
    
    int binarySearch(int[] diffs, int[] times, long limit) {
        // level의 범위를 먼저 구해야함.
        int s = 100_000;
        int e = 1;
        
        while (e <= s) {
            int curLevel = (s + e) / 2;
            
            long total = 0;
            for (int i=0; i<diffs.length; ++i) {
                if (diffs[i] <= curLevel) total += times[i];
                else total += (times[i] + times[i-1]) * (diffs[i] - curLevel) + times[i];
            }
            
            if (total <= limit) s = curLevel - 1;
            else e = curLevel + 1;
        }        
        return e;
    }
}