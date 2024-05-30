import java.util.HashSet;
import java.util.Set;

class Solution {
     public int solution(int[] elements) {
        int length = elements.length;

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                int sum = 0;
                for (int k = j; k < i + j; k++) {
                    sum += elements[k % length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}