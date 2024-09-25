import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        dfs("", numbers);
        
        for (int num : set) {
            if (primeNumber(num)) {
                answer++;
            }
        }
        return answer;
    }

    private void dfs(String temp, String numbers) {
        if (!temp.equals("")) {
            set.add(Integer.parseInt(temp));
        }

        for (int i = 0; i < numbers.length(); i++) {
            dfs(temp + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }

    private boolean primeNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}