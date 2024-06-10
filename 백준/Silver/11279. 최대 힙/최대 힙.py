import heapq
import sys

if __name__ == '__main__':

    N = int(sys.stdin.readline())
    heap = []

    for _ in range(N):

        n = int(sys.stdin.readline())
        if n == 0:
            if heap:
                _, ans = heapq.heappop(heap)
                print(ans)
            else:
                print(0)

        else:
            heapq.heappush(heap, (-n, n))

