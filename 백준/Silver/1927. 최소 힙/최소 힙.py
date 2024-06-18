import heapq
import sys

if __name__ == '__main__':

    heap = []

    N = int(sys.stdin.readline())
    ans = []
    for _ in range(N):
        n = int(sys.stdin.readline())

        if n == 0:
            if heap:
                ans.append(str(heapq.heappop(heap)))
            else:
                ans.append("0")
        else:
            heapq.heappush(heap, n)

    print("\n".join(ans))