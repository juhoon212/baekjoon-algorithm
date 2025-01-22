# GraphBFS
```
public class Graph {
  boolean visited[] = new boolean[]{};
  List<Integer> graph[] = new ArrayList<>[]{};

  public int bfs(int value) {

  Queue<Integer> q = new LinkedList<>();
  q.offer(value);

  while (!q.isEmpty()) {
  int poll = q.poll();

  for (int now : graph[poll]) {

  if (!visited[now]) {
  q.offer(now);
  visited[now] = true;
}
}
}

}
}
```


# GraphDfs

```
public class GraphBfs {

    boolean visited[] = new boolean[]{};
    List<Integer> graph[] = new ArrayList[]{};

    public void dfs(int value) {

        for (int v : graph[value]) {
            visited[v] = true;
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}
```
