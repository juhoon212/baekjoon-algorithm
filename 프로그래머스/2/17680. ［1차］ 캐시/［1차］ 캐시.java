import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int solution(int cacheSize, String[] cities) {
         int answer = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();

        for (String city : cities) {

            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            if (!queue.contains(city.toUpperCase())) {
               if (queue.size() == cacheSize) {
                   queue.poll();
               }
               answer += 5;
            } else {
                answer++;
                queue.remove(city.toUpperCase());
            }

            queue.add(city.toUpperCase());
        }


        return answer;
    }
}