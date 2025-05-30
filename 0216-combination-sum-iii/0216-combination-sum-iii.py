class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        answers = []
        
        def backTrack(start, k, n, answer, answers):
            if (len(answer) == k and n == 0):
                answers.append(answer[:])
                return
            
            for i in range(start, 9 + 1):
                answer.append(i)
                backTrack(i+1, k, n-i, answer, answers)
                answer.pop()

        backTrack(1, k, n, [], answers)
        return answers
