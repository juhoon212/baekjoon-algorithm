import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())

    var firstArr = arrayOfNulls<Int>(N)

    for (i in 0 until N ) {
        firstArr[i] = st.nextToken().toInt()
    }

    firstArr.sort() // 1,2,3,4,5

    st = StringTokenizer(br.readLine())

    var M = st.nextToken().toInt()

    var secondArr = arrayOfNulls<Int>(M)

    st = StringTokenizer(br.readLine())
    for (i in 0 until M) {
        secondArr[i] = st.nextToken().toInt()
    }

    for (i in 0 until M) {
        var start: Int = 0
        var end: Int = firstArr.size - 1
        var find: Boolean = false
        while (start <= end) {
            var mid: Int = (end + start) / 2
            var mid_value: Int? = firstArr[mid]

            if(mid_value!! > secondArr[i]!!) {
                end = mid - 1
            }else if (mid_value < secondArr[i]!!) {
                start = mid + 1
            } else {
                find = true
                break
            }
        }

        if (find) {
            println(1)
        } else {
            println(0)
        }
    }






}