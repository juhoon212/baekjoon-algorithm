class Solution {
    public int maxVowels(String s, int k) {
        int sLength = s.length();
        int max = 0;

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int start = 0;
        int end = k;
        int result = 0;

        for (int i=0; i<k; ++i) {
            if (vowels.contains(s.charAt(i))) {
                result++;
            }
        }

        max = result;

        while (end < sLength) {
            if (vowels.contains(s.charAt(start))) {
                result--;
            }

            if (vowels.contains(s.charAt(end))) {
                result++;
            }

            max = Math.max(max, result);
            start++;
            end++;
        }
        return max;
    }
}