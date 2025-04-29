class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = [False] * len(rooms)

        def bfs():
            q = deque()
            q.append(rooms[0])
            visited[0] = True
            while q:
                now = q.popleft()
                
                for num in now:
                    if not visited[num]:
                        visited[num] = True
                        q.append(rooms[num])
        bfs()

        return all(visited)
                
        