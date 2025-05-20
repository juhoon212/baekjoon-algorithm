class Solution {
    public int maxVowels(String s, int k) {
        int sLength = s.length();
        int max = 0;
        
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        int start = 0;
        int end = k;
        int result = 0;

        for (int i=0; i<k; ++i) {
            if (set.contains(s.charAt(i))) {
                result++;
            }
        }

        max = result;

        while (end < sLength) {
            if (set.contains(s.charAt(start))) {
                result--;
            }

            if (set.contains(s.charAt(end))) {
                result++;
            }

            max = Math.max(max, result);
            start++;
            end++;
        }
        return max;
    }
}