class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var row: Array<Int> = Array(n) { 1 }

        for (i in 0 until m-1) {
            var newRow: Array<Int> = Array(n) { 1 }
            for (j in n - 2 downTo 0) {
                newRow[j] = newRow[j+1] + row[j]
            }
            row = newRow
        }

        return row[0]
    }
}