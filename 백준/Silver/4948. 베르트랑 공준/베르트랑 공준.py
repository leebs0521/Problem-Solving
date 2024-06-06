import math

if __name__ == '__main__':
    # 100,000 = 10,000,000,000 5

    MAX = 123456 * 2
    prime_count = [0 for _ in range(MAX+1)]
    prime = [True for i in range(MAX + 1)]

    prime[1] = False

    for i in range(2, int(math.sqrt(MAX)) + 1):
        if prime[i]:
            j = 2
        while i * j <= MAX:
            prime[i * j] = False
            j += 1

    for i in range(1, MAX+1):
        if prime[i]:
            prime_count[i] = prime_count[i-1] + 1
        else:
            prime_count[i] = prime_count[i-1]

    while 1:
        n = int(input())

        if n == 0:
            break

        print(prime_count[2 * n] - prime_count[n])