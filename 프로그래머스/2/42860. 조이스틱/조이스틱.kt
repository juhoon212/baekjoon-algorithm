class Solution {
    fun solution(name: String): Int {
        var answer = 0
        // 알파벳을 바꾸는것 + 양옆으로 움직이는거
        val length = name.length;
        var move = length-1;
        for (i in 0 until length) {
            val c = name[i]
            answer += min(c);
            
            var next = i+1;
            while (next < length && name[next] == 'A') {
                next++;
            }
            
            // 오른쪽으로 U턴
            move = minOf(move, (length - next) + (i*2))
            move = minOf(move, (length - next) * 2 + i)
        }
        return move + answer
    }
    
    fun min(c: Char): Int {
        val a = c - 'A';
        val b = 'Z' - c + 1;
        return minOf(a,b)
    }  
}