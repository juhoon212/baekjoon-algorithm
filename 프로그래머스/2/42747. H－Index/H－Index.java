import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 정렬
        Arrays.sort(citations); // 0 1 3 5 6

        for (int i = 0; i < citations.length; i++) {
            int length = citations.length - i;

            if (citations[i] >= length) {
                answer = length;
                break;
            }
        }


        return answer;
        
        
    }
}