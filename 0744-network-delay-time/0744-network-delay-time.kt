class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val graph = List(n+1) { mutableListOf<Pair<Int, Int>>() }

        for (time in times) {
            graph[time[0]].add(time[2] to time[1])
        }

        val costs: MutableMap<Int, Int> = mutableMapOf()
        val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue<Pair<Int, Int>>(compareBy {it.first})
        pq.add(0 to k)

        while (pq.isNotEmpty()) {
            val (curCost, curNode) = pq.poll()
            if (curNode !in costs) {
                costs[curNode] = curCost
                for ((nextCost, nextNode) in graph[curNode]) {
                    val sum: Int = curCost + nextCost
                    pq.add(sum to nextNode)
                }
            }
        }

        return if (costs.size == n) costs.values.maxOrNull() ?: -1
        else -1
    }
}