if __name__ == '__main__':

    INF = int(1e9)
    n = int(input())

    tri = []

    for _ in range(n):
        tri.append(list(map(int, input().split())))

    dp = [[INF] * (i+1) for i in range(n)]
    dp[0][0] = tri[0][0]

    for i in range(1, n):
        for j in range(len(tri[i])):
            if j == 0:
                dp[i][j] = tri[i][j] + dp[i - 1][j]
            elif j == len(tri[i]) - 1:
                dp[i][j] = tri[i][j] + dp[i - 1][j - 1]
            else:
                dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j]
    print(max(dp[n - 1]))