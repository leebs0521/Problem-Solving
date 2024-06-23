import heapq

if __name__ == "__main__":

    N, M, X = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    for _ in range(M):
        start, end, cost = map(int, input().split())
        graph[start].append([end, cost])

    def dijkstra(start):
        dists = [float('inf')] * (N+1)
        dists[start] = 0
        pq = []								        # 최단 거리 테이블을 heap으로 구현
        heapq.heappush(pq, (0, start))				# heap에 (가중치, 노드) 형식으로 삽입
        while pq:
            dist, cur = heapq.heappop(pq)		    # 최소힙이므로 가중치가 가장 작은 값이 pop
            if dists[cur] >= dist:					# 이미 최솟값 구했는지 확인
                for v, cost in graph[cur]:		    # 연결된 노드들 확인
                    if dist + cost < dists[v]:		# 가중치가 더 작은 값이면 갱신
                        dists[v] = dist + cost
                        heapq.heappush(pq, (dist + cost, v))
        return dists
    
    # X -> 다른 마을까지의 최단 경로 구하기
    ans = dijkstra(X)
    ans[0] = 0
    
    for i in range(1, N+1):
        # i -> X 까지의 최단 경로 추가
        if i != X:
            res = dijkstra(i)
            ans[i] += res[X]

    print(max(ans))
