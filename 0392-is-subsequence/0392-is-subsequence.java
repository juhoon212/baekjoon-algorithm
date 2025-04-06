class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;

        if (s.equals("")) {
            return true;
        }

        for (int i=0; i<t.length(); ++i) {
            if (s.charAt(start) == t.charAt(i)) {
               start++;
            } 

            if (start == s.length()) break;
        }

        return start == s.length();
    }
}