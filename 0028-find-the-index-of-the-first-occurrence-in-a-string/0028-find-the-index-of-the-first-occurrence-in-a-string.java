class Solution {
    public int strStr(String haystack, String needle) {
        return KMP(haystack, needle);
    }

    int KMP(String parent, String pattern) {
        int[] fail = makeFailArray(pattern);
        int j=0;

        for (int i=0; i<parent.length(); ++i) {
            while (j>0 && parent.charAt(i) != pattern.charAt(j)) {
                j = fail[j-1];                 
            }

            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return i - pattern.length() + 1;
                } else {
                    j++;
                }
            }
        }
        return -1;
    }

    int[] makeFailArray(String pattern) {
        int j=0;

        int[] failArr = new int[pattern.length()];
        for (int i=1; i<pattern.length(); ++i) {
            while (j>0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = failArr[j-1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                failArr[i] = ++j;
            }
        }
        return failArr;
    }
}