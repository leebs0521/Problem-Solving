def func(n):

    if n < 10:
        return n * 11

    else:
        sum = n % 10 + n // 10

        return (n % 10) * 10 + sum % 10


if __name__ == '__main__':

    initial = int(input())
    n = initial
    cnt = 0

    while 1:
        cnt += 1
        n = func(n)
        if initial == n:
            break

    print(cnt)
