import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;

        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - days; i++) {
            Map<String, Integer> temp = new HashMap<>();
            
            for (int j = 0; j < days; j++) {
                temp.put(discount[i + j], temp.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean isPossible = true;
            
            for (String key : temp.keySet()) {
                if (map.get(key) != temp.get(key)) {
                    isPossible = false;
                    break;
                }
            }

            answer += isPossible ? 1 : 0; 
        }

        return answer;
    }
}