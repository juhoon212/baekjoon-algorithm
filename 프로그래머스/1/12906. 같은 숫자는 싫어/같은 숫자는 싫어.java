import java.util.*;
import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        Arrays.stream(arr)
                .boxed()
                .forEach(num -> {
                    if (stack.isEmpty() || !stack.peek().equals(num)) {
                        stack.push(num);
                    }
                });

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}