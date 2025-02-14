class Solution(object):
    def canVisitAllRooms(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: bool
        """
        visited = [False] * len(rooms)
        def bfs(v):
            q = deque()
            q.append(v)
            visited[v] = True

            while q:
                cur_v = q.popleft()
                for next_v in rooms[cur_v]:
                    if not visited[next_v]:
                        q.append(next_v)
                        visited[next_v] = True
        bfs(0)
        return all(visited)

        