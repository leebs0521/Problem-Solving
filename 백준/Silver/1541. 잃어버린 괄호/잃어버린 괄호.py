import sys

if __name__ == "__main__":

    inputs = sys.stdin.readline()
    num = ""
    ans = 0
    is_minus = False

    for ch in inputs:

        if ch == '+' or ch == '-' or ch == inputs[-1]:

            if ch == inputs[-1]:
                num += ch

            if is_minus:
                ans -= int(num, 10)

            else:
                ans += int(num, 10)

            num = ""
        else:
            num += ch

        if ch == '-':
            is_minus = True

    print(ans)
