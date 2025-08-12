class Solution {
    public int[] solution(int n, int m) {
        // [0] = 최대공약수, [1] = 최소 공배수
        
        int gcd = GCD(n, m);
        int lcm = LCM(gcd, n*m); // 최소공배수는 두수의 곱 / 최대공약수
        return new int[]{gcd, lcm};
    }
    
    int GCD(int n, int m) { // 유클리드 호재법
        if (m == 0) {
            return n;
        }
        
        return GCD(m, n%m);
    }
    
    int LCM(int gcd, int multiple) {
        return multiple / gcd;
    }
}