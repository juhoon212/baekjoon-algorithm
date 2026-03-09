class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var row: Array<Int> = Array(n) { 1 }
        
        for (i: Int in 1 until m) {
            var newRow: Array<Int> = Array(n) { 1 }
            for (j: Int in n-2 downTo 0) {
                newRow[j] = newRow[j+1] + row[j]
            }
            row = newRow
        }
        return row[0]
    }
}