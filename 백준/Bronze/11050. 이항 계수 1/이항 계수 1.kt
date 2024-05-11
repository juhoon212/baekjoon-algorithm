
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    val N: Int = st.nextToken().toInt()
    val K: Int = st.nextToken().toInt()

    var arr = Array<Array<Int>>(N + 1) { Array<Int>(N + 1) {0} }

    for (i: Int in 0 .. N step 1) {
        arr[i][i] = 1
        arr[i][0] = 1
        arr[i][1] = i
    }

    // 점화식으로 배열 완성하기

    for (i: Int in 2 .. N step 1) {
        for (j: Int in 1 until i step 1) {
            arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1]
        }
    }

    bw.write(arr[N][K].toString())
    bw.flush()
    bw.close()
    br.close()
}