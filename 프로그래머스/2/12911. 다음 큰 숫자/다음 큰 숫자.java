
public class Solution {

    public int solution(int n) {
        int answer = 0;

        // n보다 큰 자연수
        // 2진수 변환 시 1의 갯수가 같은 수

        boolean isFind = true;
        int temp = n;
        // n의 이진수 값 구하기
        int nCount = 0;

        while (isFind) {
            if (temp % 2 == 1) {
                nCount++;
            }

            temp = temp / 2;

            if (temp == 0) {
                isFind = false;
            }
        }
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            int moreCount = 0;

            isFind = true;

            int temp2 = i;

            while (isFind) {
                if (temp2 % 2 == 1) {
                    moreCount++;
                }

                temp2 = temp2 / 2;

                if (temp2 == 0) {
                    isFind = false;
                }
            }
            if (moreCount == nCount) {
                answer = i;
                return answer;
            }
        }
        return answer;
    }
}
