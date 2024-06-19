import sys

if __name__ == "__main__":

    n = int(sys.stdin.readline())
    lst = list(map(int, sys.stdin.readline().split()))

    lst.sort()
    ans = 0
    waiting_time = 0
    for time in lst:
        waiting_time += time
        ans += waiting_time

    print(ans)