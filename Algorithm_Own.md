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
