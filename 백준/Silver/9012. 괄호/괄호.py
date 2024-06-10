import sys
from collections import deque

if __name__ == '__main__':
    T = int(sys.stdin.readline())

    for _ in range(T):
        strings = sys.stdin.readline().replace("\n","")
        stack = deque()
        flag = True
        for ch in strings:
            if ch == '(':
                stack.append(ch)

            else:
                if len(stack) != 0 and stack.pop() == '(':
                    continue
                else:
                    flag = False
                    break

        if len(stack) != 0 or not flag:
            print("NO")
        else:
            print("YES")