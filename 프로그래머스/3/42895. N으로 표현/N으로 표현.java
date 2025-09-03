import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (number == N) return 1;
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i=0; i<8; ++i) {
            list.add(new HashSet<>());
        }
        
        for (int i=0; i<8; ++i) {
            StringBuilder sb = new StringBuilder();
            
            for (int j=0; j<=i; ++j) {
                sb.append(String.valueOf(N));
            }
            
            list.get(i).add(Integer.parseInt(sb.toString()));
        }
        
        for (int i=1; i<8; ++i) {
            for (int j=0; j<i; ++j) {
                //Set<Integer> temp = new HashSet<>();
                Set<Integer> arg1 = list.get(j);
                Set<Integer> arg2 = list.get(i-j-1);
                for (int a : arg1) {
                    for (int b : arg2) {
                        list.get(i).add(a + b);
                        list.get(i).add(a - b);
                        list.get(i).add(a * b);
                        if (b != 0) list.get(i).add(a / b);
                    }
                }
            }
            
            if (list.get(i).contains(number)) {
                return i+1;
            }
        }
        return -1;
    }
}