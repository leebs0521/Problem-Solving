N, K = map(int, input().split())  # N : 화폐 종류수, K : 거슬러 줄 돈

coins = []
for _ in range(N):
    coins.append(int(input()))
coins.sort(reverse=True)

answer = 0
for coin in coins:
    if K >= coin:
        answer += K // coin
        K %= coin
        if K <= 0:
            break
print(answer)
