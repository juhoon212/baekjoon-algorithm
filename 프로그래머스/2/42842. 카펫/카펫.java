class Solution {
    public int[] solution(int brown, int yellow) {

        // 방정식 구해서 풀기!
        // yellow = yw * yh
        // brown = (yw + 2) * (yh + 2)
        // yellow = (bw - 2) * (bh - 2)
        // brown = 2(bw + bh) - 4
        // brown = 2bw + 2bh - 4
        // 2bw = brown - 2bh - 4
        // bw = (brown - 2bh - 4) / 2
        for (int i = 1; i <= brown / 2 + 1; i++) {
            int bw = (brown - 2 * i + 4) / 2;
            int yh = i - 2;
            int yw = bw - 2;
            
            if (yellow == yh * yw && yellow + brown == bw * i) {
                return new int[]{bw, i};
            }
        }
        return null;
    }
}