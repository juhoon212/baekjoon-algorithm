class RecentCounter() {

    val q: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        q.add(t)
        while (t-q.peek() > 3000) {
            q.poll()
        }

        return q.size
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */