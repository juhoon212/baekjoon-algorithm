import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1],
                    map.getOrDefault(clothes[i][1], 1) + 1);
        }

        Collection<Integer> test = map.values();
        answer = test.stream().reduce(1, (a, b) -> a * b) - 1;

        return answer;
    }
}