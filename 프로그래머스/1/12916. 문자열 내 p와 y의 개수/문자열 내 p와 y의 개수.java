class Solution {
    boolean solution(String s) {
        boolean answer = true;

        final String lowerCase = s.toLowerCase();
        final char[] charArray = lowerCase.toCharArray();
        int p = 0;
        int y = 0;

        for (char word : charArray) {
            if (word == 'p') p++;
            else if (word == 'y') y++;

        }

        if (p == y) return true;
        else return false;
    }
}