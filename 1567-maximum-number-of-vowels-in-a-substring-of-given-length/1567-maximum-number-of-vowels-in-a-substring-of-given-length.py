class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        count = 0
        for i in range(k):
            if s[i] in vowels:
                count += 1
        # max 변수에 count 값 담아두고 count 재사용
        result = count

        for i in range(k, len(s)):
            if s[i] in vowels:
                count += 1
            if s[i-k] in vowels:
                count -= 1
            result = max(result, count)
        return result
        
        


            
        