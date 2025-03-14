class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = collections.defaultdict(list) # 이중 그래프를 만들고
        
        for time in times:
            graph[time[0]].append((time[2], time[1]))
        
        pq = []
        costs = {}
        
        heapq.heappush(pq, (0, k))

        while pq:
            cur_v, cur_node = heapq.heappop(pq)
            if cur_node not in costs:
                costs[cur_node] = cur_v
                for next_cost, next_node in graph[cur_node]:
                    sum_cost = cur_v + next_cost
                    heapq.heappush(pq, (sum_cost, next_node))
        
        # 최소 비용중에 최고 최소비용 (signal을 보낼 수 있는 최소 비용)
        for i in range(1, n+1):
            if i not in costs:
                return -1
        
        return max(costs.values())