import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 탐욕법
        // 최적의 값을 구해야한다.
        // 현재 숫자가 이전 숫자보다 크면 이전숫자를 지운다.
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));
        for (int i=1; i<number.length(); ++i) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택의 모든 문자 합치기
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}