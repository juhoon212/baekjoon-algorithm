
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int selected = nums.length / 2;

        for (int num : nums) {
            if (set.size() == selected) {
                return set.size();
            }
            set.add(num);
        }

        return set.size();


    }
}