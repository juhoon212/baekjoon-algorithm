import java.util.*;

class Solution {
    int[] discount = new int[]{10, 20, 30, 40};
    int[] temp;
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것 (우선순위 높음)
        // 2. 이모티콘 판매액을 늘리는것
        // 3. 사용자의 비율이 할인율보다 낮거나 같으면 모두 구매
        // 이 때 최대의 이모티콘 플러스 가입자 및 판매액을 구하라.
        // 이 때 이모티콘마다 할인율은 다를 수 있으며, 할인율은 10, 20, 30, 40
        // 조합으로 풀 수 있을듯.
        temp = new int[emoticons.length];
        dfs(0, users, emoticons);
        
        return answer;
    }
    
    void dfs(int idx, int[][] users, int[] emoticons) {
        // 탈출 조건
        if (idx == emoticons.length) {
            calc(users, emoticons);
            return;
        }
        
        // 이모티콘의 갯수만큼 돌린다.
        for (int i=0; i<discount.length; ++i) {
            temp[idx] = discount[i]; // [10, 10] , [10, 20]
            dfs(idx+1, users, emoticons);
        }
    }
    
    // 여기서 각 할인율마다 이모티콘 플러스 가입자와 이모티콘 판매액을 구하고 answer 배열과 비교하여
    // 값이 더 크다면 갱신한다.
    void calc(int[][] users, int[] emoticons) {
        int[] total = new int[2];
        for (int[] user : users) {
            int userDiscount = user[0];
            int userCost = user[1];
            int curCost=0; // 유저별로 초기화 해야함.
            
            for (int i=0; i<emoticons.length; ++i) {
                if (temp[i] >= userDiscount) {
                    curCost += emoticons[i] * (100 - temp[i]) / 100;
                }
            }
            
            // 유저 한명당 이모티콘 구매를 끝내면 할인된 비용이 유저의 비용보다 높다면 플러스 가입 +1
            if (curCost >= userCost) total[0]++;
            else total[1] += curCost;
        }
        
        if (answer[0] < total[0] || (answer[0] == total[0] && answer[1] <= total[1])) {
            answer[0] = total[0];
            answer[1] = total[1];
        }
    }
}