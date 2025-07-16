import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        var bases = Arrays.stream(bans)
            .map(it -> convert(it))
            .sorted()
            .collect(Collectors.toList());
        
        var target = n;
        
        for (Long base : bases) {
            if (target >= base) ++target;
            else break;
        }
        
        return convertToString(target);
    }
    
    String convertToString(long target) {
        var number = target;
        var result = new StringBuilder();
        
        while (number-- > 0) {
            var c = (int) ('a' + (number % 26));
            result.append((char) c);
            number /= 26;
        }
        
        return result.reverse().toString();
    }
    
    Long convert(String input) {
        var result = 0L;
        for (char c : input.toCharArray()) {
            var value = c - 'a' + 1;
            result = result * 26 + value;
        }
        
        return result;
    } 
}