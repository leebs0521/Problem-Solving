import sys
from collections import deque

if __name__ == '__main__':
    stack = deque()

    k = int(sys.stdin.readline())

    for _ in range(k):
        n = int(sys.stdin.readline())

        if n == 0:
            stack.pop()

        else:
            stack.append(n)
    sum = 0
    while stack:
        sum += stack.pop()

    print(sum)