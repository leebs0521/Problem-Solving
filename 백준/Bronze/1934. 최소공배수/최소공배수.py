import sys


def gcd(a, b):

    while (a % b) != 0:
        temp = a % b
        a = b
        b = temp

    return b


if __name__ == "__main__":

    t = int(sys.stdin.readline())

    for _ in range(t):

        a, b = map(int, sys.stdin.readline().split())

        gcd_num = gcd(a, b)

        print(a*b//gcd_num)
