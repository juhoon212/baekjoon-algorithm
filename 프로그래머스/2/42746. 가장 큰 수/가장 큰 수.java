import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            };
        };

        Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted(comparator)
                .forEach(sb::append);
        
        answer = sb.toString();

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}