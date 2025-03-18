class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        String shortWord;
        if (word1.length() <= word2.length()) {
            shortWord = word1;
        } else shortWord = word2;

        String longWord;
        if (word1.length() >= word2.length()) {
            longWord = word1;
        } else longWord = word2;

        int longWordLength = Math.max(word1.length(), word2.length());
        

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<shortWord.length(); ++i) {
            sb.append(word1Arr[i]);
            sb.append(word2Arr[i]);
        }

        for (int i=shortWord.length(); i<longWordLength; ++i) {
            sb.append(longWord.charAt(i));
        }

        return sb.toString();
        
    }
}