import sys
from collections import deque

if __name__ == '__main__':

    ans = []
    while True:
        inputs = sys.stdin.readline().replace("\n","")

        if inputs == ".":
            break

        else:
            stack = deque()
            flag = True
            for ch in inputs:
                if ch == '(' or ch == '[':
                    stack.append(ch)

                elif ch == ')' or ch == ']':

                    # 비어 있으면 false
                    if not stack:
                        flag = False
                        break

                    c = stack.pop()

                    if (ch == ')' and c == '(') or (ch == ']' and c == '['):
                        continue
                    else:
                        flag = False

            if flag and not stack:
                ans.append("yes")
            else:
                ans.append("no")

    print("\n".join(ans))