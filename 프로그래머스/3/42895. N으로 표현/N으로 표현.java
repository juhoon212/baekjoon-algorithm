import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        int answer = 0;
        List<Set<Integer>> list = new ArrayList<>();
        
        // set으로 채워주기
        for (int i=0; i<8; ++i) {
            list.add(new HashSet<Integer>());
        }
        
        for (int i=0; i<list.size(); ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<=i; ++j) {
                sb.append(N);
            }
            list.get(i).add(Integer.parseInt(sb.toString()));
        }
        
        for (int i=1; i<8; ++i) {
            for (int j=0; j<i; ++j) {
                Set<Integer> temp = new HashSet<>();
                for (int op1 : list.get(j)) {
                    for (int op2 : list.get(i-j-1)) {
                        temp.add(op1 + op2);
                        temp.add(op1 - op2);
                        temp.add(op1 * op2);
                        if (op2 != 0) {
                            temp.add(op1 / op2);
                        }
                    }
                }
                
                list.get(i).addAll(temp);
            }
            
            if (list.get(i).contains(number)) {
                return i+1;
            }
        }
        return -1;
    }
}