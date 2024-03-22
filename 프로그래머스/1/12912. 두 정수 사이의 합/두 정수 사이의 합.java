class Solution {
  public long solution(int a, int b) {
        return prefix(Math.min(a, b) , Math.max(a, b));
    }

    private long prefix(long a, long b) {
        return (a + b) * (b - a + 1) / 2;
    }
}