class Solution {
    public int maxVowels(String s, int k) {
        // leetcode
        // k = 3, lee, eet, etc ...
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        
        int result = 0;
        for (int i=0; i<k; ++i) {
            if (vowels.contains(s.charAt(i))) {
                result++;
            }
        }
        int max = result;
        for (int i=k; i<s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                result++;
            } 
            if (vowels.contains(s.charAt(i-k))) {
                result--;
            }
            max = Math.max(max, result);
        }

        return max;
    }
}