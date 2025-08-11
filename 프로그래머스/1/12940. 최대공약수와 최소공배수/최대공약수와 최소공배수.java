class Solution {
    public int[] solution(int n, int m) {
        int gcd = GCD(n, m);
        int lcm = LCM(n * m, gcd);
        return new int[]{gcd, lcm};
    }
    
    int GCD(int n, int m) {
        if (m == 0) return n;
        return GCD(m, n%m);
    }
    
    int LCM(int multiple, int gcd) {
        return multiple / gcd;
    }
}