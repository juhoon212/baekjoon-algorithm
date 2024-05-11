
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())

    val N: Int = st.nextToken().toInt()
    val K: Int = st.nextToken().toInt()

    fun factorial(num: Int): Int {
        return if (num <= 1) 1
        else num * factorial(num - 1)
    }

    var result: Int = factorial(N) / (factorial(N - K) * factorial(K))

    bw.write(result.toString())
    bw.flush()
    bw.close()
    br.close()
}