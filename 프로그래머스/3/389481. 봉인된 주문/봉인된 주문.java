import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        // 26진법으로 고쳐서 list에 담는다.
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
        
        // 26으로 나누면서 그 나머지를 'a' 와 더해서 stringbuilder에 담고 계속해서 26으로 나눈다.
        // 뒤에서 부터 계산 (target이 777이면 0부터 계산이 아니라 777부터 계산하니까) reverse() 써줘야함.
        while (num-- > 0) {
            int c = (int)('a' + (num % 26));
            sb.append((char) c);
            num /= 26;
        }
        
        return sb.reverse().toString();
    }
    
    // 26진법 변환
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