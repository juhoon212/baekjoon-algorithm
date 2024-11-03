import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        Arrays.stream(participant)
                .forEach(
                        i -> map.put(
                                i, map.getOrDefault(i , 0) + 1));

        Arrays.stream(completion)
                .forEach(i -> {
                    Integer i1 = map.get(i);
                    int i2 = i1 - 1;
                    map.put(i, i2);
                });

        StringBuilder sb = new StringBuilder();

        map.keySet()
                .stream()
                .filter(i -> map.get(i) > 0)
                .forEach(sb::append);

        return sb.toString();
    }
}