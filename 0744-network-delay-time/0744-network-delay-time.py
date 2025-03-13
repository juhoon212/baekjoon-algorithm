class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        # 최단거리 다익스트라
        graph = collections.defaultdict(list) # 그래프 초기화

        for time in times:
            graph[time[0]].append((time[2], time[1])) # 이중 linkedList 구현 ex)  {2 : [(1, 1)]}

        pq = []
        costs = {}

        heapq.heappush(pq, (0, k))

        while pq:
            cur_cost, cur_node = heapq.heappop(pq)
            if cur_node not in costs:
                costs[cur_node] = cur_cost
                for cost, next_node in graph[cur_node]:
                    sum_cost = cost + cur_cost
                    heapq.heappush(pq, (sum_cost, next_node))
        
        for i in range(1, n+1):
            if i not in costs:
                return -1

        return max(costs.values())

                

        
