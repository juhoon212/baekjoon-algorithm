class Solution {
    public int longestOnes(int[] nums, int k) {
        // nums 배열을 돌면서
        // left, right 설정
        // right는 하나씩 이동하면서 0을 만나면 zeroCount 하나씩 올림
        // zeroCount가 k보다 많아질 시에는 left를 한칸씩 이동
        // 언제까지? nums[left]가 0을 만나서 zeroCount가 k 보다 작아질때까지
        // right - left + 1 -> 현재 최대 return 값
        
        int numsLength = nums.length;
        int max = 0;
        int left = 0;
        int zeroCount = 0;

        for (int r=0; r<numsLength; ++r) {
            if (nums[r] == 0) zeroCount++;
            
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            int currentLength = r - left + 1;
            max = Math.max(max, currentLength);
        }

        return max;        
    }
}