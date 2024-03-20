
import java.math.BigInteger;

public class Solution {

    public int solution(int n) {
        int answer = 1;
        int f1 = 0, f2 = 1;

        for(int i = 2; i<=n; i++){
            answer = (f1 + f2)%1234567;
            f1 = f2;
            f2 = answer;
        }

        //if(n>=2) answer %= 1234567;
        return answer;
    }

}
