class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        output = ""
        long_word = word1 if len(word1) >= len(word2) else word2
        short_len = len(word1) if len(word1) < len(word2) else len(word2)
        for i in range(short_len):
            output += word1[i] + word2[i]

        output += long_word[short_len:]
        return output