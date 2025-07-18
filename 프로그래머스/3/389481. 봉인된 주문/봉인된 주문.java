import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        List<Long> values = Arrays.stream(bans)
            .map(ban -> convertTo26(ban))
            .sorted()
            .collect(Collectors.toList());
        
        var target = n;
        
        for (Long value : values) {
            if (target >= value) target++;
            else break;
        }
        
        return convertToString(target);
    }
    
    String convertToString(long target) {
        var sb = new StringBuilder();
        
        var num = target;
        
        while (num-- > 0) {
            int c = (int)('a' + (num % 26));
            sb.append((char) c);
            num /= 26;
        }
        
        return sb.reverse().toString();
    }
    
    Long convertTo26(String target) {
        // a~z = 26
        Long result = 0L;
        for (char c : target.toCharArray()) {
            int value = c - 'a' + 1;
            result = result * 26 + value;
        }
        
        return result;
    }
}