import java.util.*;

class Solution {
    int[] discounts = new int[]{10, 20, 30, 40};
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘 가입자를 최대로 늘리는것
        // 판매액을 최대한 늘리는 것
        
        // 이모티콘마다 할인율은 다를 수 있으며, 할인율은 10, 20, 30, 40 중 하나로 설정
        // 할인율 ^ emoticons.length
        int[] temp = new int[emoticons.length];
        dfs(0, temp, users, emoticons);
        return answer;
    }
    
    void dfs(int idx, int[] temp, int[][] users, int[] emoticons) {
        // 탈출 조건
        if (idx == emoticons.length) {
            // 할인율 ^ emoticons.length를 다돌았을때 가장 큰수를 answer[] 배열에 담는다. 
            calc(temp, users, emoticons);
            return;
        }
        
        // 조합 emoticons.length 만큼의 배열을 만들어서 (10, 10), (10, 20), (10, 30) 하나씩 바꿔나가면서 구한다.
        for (int i=0; i<discounts.length; ++i) {
            temp[idx] = discounts[i];
            dfs(idx+1, temp, users, emoticons);
        }
    }
    
    void calc(int[] temp, int[][] users, int[] emoticons) {
        int[] total = new int[emoticons.length];
        // 유저 당
        for (int[] user : users) {
            int userPercent = user[0];
            int userCost = user[1];
            
            int sum = 0; // 이모티콘 구매비용
            for (int i=0; i<emoticons.length; ++i) {
                // 현재 할인율이 유저가 구매하는 퍼센트보다 높으면 산다.
                if (temp[i] >= userPercent) {
                    sum += emoticons[i] * (100 - temp[i]) / 100;
                }
            }
            if (sum >= userCost) total[0]++;
            else total[1] += sum;
        }
        
        if (answer[0] < total[0] || (answer[0] == total[0] && total[1] >= answer[1])) {
            answer[0] = total[0];
            answer[1] = total[1];
        }
    }
}