import sys
from collections import deque

if __name__ == '__main__':
    n = int(sys.stdin.readline())
    element = 1
    stack = deque()
    output = []
    for _ in range(n):
        num = int(sys.stdin.readline())

        while element <= num:
            stack.append(element)
            output.append('+')
            element += 1

        if stack[-1] == num:
            stack.pop()
            output.append('-')

    if stack:
        print('NO')
    else:
        print('\n'.join(output))