INF = int(1e9)

if __name__ == '__main__':

    n = int(input())
    m = int(input())

    dist = [[INF] * n for _ in range(n)]

    for idx in range(n):
        dist[idx][idx] = 0

    for _ in range(m):
        str = input().split(" ")
        start = int(str[0])
        adj = int(str[1])
        d = int(str[2])
        if d < dist[start-1][adj-1]:
            dist[start-1][adj-1] = d

    for k in range(n):
        for a in range(n):
            for b in range(n):
                dist[a][b] = min(dist[a][b], dist[a][k] + dist[k][b])

    for start in range(n):
        for adj in range(n):
            if dist[start][adj] == INF:
                print(0, end=" ")
            else:
                print(dist[start][adj], end=" ")

        print()