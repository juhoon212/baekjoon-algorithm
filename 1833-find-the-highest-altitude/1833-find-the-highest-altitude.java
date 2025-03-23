class Solution {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int result = 0;
        for (int i=0; i<gain.length; ++i) {
            sum += gain[i];
            result = Math.max(sum, result);
        }

        return result;
    }
}