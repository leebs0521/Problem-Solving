from collections import deque
import sys

if __name__ == "__main__":
    
    N = int(sys.stdin.readline())
    
    lst = list(map(int, sys.stdin.readline().split()))
    
    dp = [0] * (N+1)
    
    for i in range(1, N+1):
        dp[i] = dp[i-1] + lst[i-1]
        
    T = int(sys.stdin.readline())
    
    for _ in range(T):
        a, b = map(int, sys.stdin.readline().split())
        print(dp[b] - dp[a] + lst[a-1])
    