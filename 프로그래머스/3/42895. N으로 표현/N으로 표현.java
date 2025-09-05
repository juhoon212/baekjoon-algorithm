import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        // list 안의 set 초기화
        for (int i=0; i<8; ++i) {
            list.add(new HashSet<>());
        }
        
        // set안에다가 5, 55, 555 ... 이런식으로 8개의 개수만큼 넣을것이다. 왜? 8보다 크면 안되니까 n < 9
        for (int i=0; i<8; ++i) {
            int num = Integer.parseInt(String.valueOf(N).repeat(i+1));
            list.get(i).add(num);
        }
        
        for (int i=1; i<=7; ++i) {
            Set<Integer> now = list.get(i);
            for (int j=0; j<i; ++j) {
                Set<Integer> arg1 = list.get(j);
                Set<Integer> arg2 = list.get(i-j-1);
                
                for (int op1 : arg1) { // 5
                    for (int op2 : arg2) { // 5
                        now.add(op1 + op2);
                        now.add(op1 - op2);
                        now.add(op1 * op2);
                        if (op1 != 0 && op2 != 0) now.add(op1 / op2);
                    }
                }
            }
            if (now.contains(number)) return i+1;
        }
        
        System.out.println(list);
        
        return -1;
    }
}