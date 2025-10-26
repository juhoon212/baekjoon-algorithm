import java.util.*;

class Solution {
    int[] discounts = new int[]{10, 20, 30, 40};
    int[] temp;
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 할인율은 10,20,30,40 으로 고정
        // 조합 문제로 풀 수 있을 것 같다.
        // 1. 이모티콘 플러스 가입자 최대
        // 2. 금액 최대
        
        // 이모티콘 할인율 ^ 이모티콘 갯수 = 최대 4^7
        // 이모티콘 각각마다 1번 이모티콘이 10퍼면, (10,10), (10,20) 이런식으로 계속 조합을 바꿔서
        // 이모티콘 플러스를 제일 많이 가입할 수 있는 경우를 구해야 한다.
        temp = new int[emoticons.length];
        dfs(0, users, emoticons);
        return answer;
    }
    
    void dfs(int idx, int[][] users, int[] emoticons) {
        // 탈출조건
        if (idx == emoticons.length) {
            calc(temp, users, emoticons);
            return;
        }
        for (int i=0; i<discounts.length; ++i) {
            temp[idx] = discounts[i];
            dfs(idx+1, users, emoticons);
        }
    }
    // temp 배열이 0이 아닌수로 꽉찼을 때 ex) [10, 20] -> 
    // 해당 비율을 가지고 users를 돌면서 기존 answer의 값보다 크다면 갱신한다.
    void calc(int[] discountRate, int[][] users, int[] emoticons) {
        int[] total= new int[2];
        for (int[] user : users) {
            int targetRate = user[0];
            int targetCost = user[1];
            
            // 이모티콘 갯수만큼 돌면서 할인된 금액의 합을 구한다.
            int sumCost = 0;
            for (int i=0; i<emoticons.length; ++i) {
                if (targetRate <= discountRate[i]) {
                    sumCost += emoticons[i] * (100 - discountRate[i]) / 100;
                }
            }
            
            if (sumCost >= targetCost) total[0] += 1; // 플러스 가입자 +1
            else total[1] += sumCost;
        }
        
        if (total[0] > answer[0] || (total[0] == answer[0] && total[1] > answer[1])) {
            answer[0] = total[0];
            answer[1] = total[1];
        }
    }
}