class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (Math.abs(a - b) != 1 || a / 2 == b / 2) {

            a = divideNum(a);
            b = divideNum(b);

            answer++;
        }

        return answer;
    }

    private int divideNum(int num) {

        if (num % 2 == 1) {
            num = num / 2 + 1;
        } else if (num % 2 == 0){
            num /= 2;
        }

        return num;
    }
}