class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var answer = ""
        for (i in strs[0].indices) {
            for (j in 1..strs.lastIndex) {
                if (i == strs[j].length || strs[j][i] != strs[0][i]) {
                    return answer
                }
            }
            answer += strs[0][i]
        }
        return answer
    }
}