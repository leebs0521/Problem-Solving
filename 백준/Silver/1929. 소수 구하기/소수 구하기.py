import math

if __name__ == '__main__':
    MAX = 1000000
    is_Prime = [True for _ in range(MAX+1)]
    is_Prime[1] = False
    
    for i in range(2, int(math.sqrt(MAX+1))):
        if is_Prime[i]:
            j = 2
            while i*j <= MAX:
                is_Prime[i*j] = False
                j += 1

    N, M = map(int, input().split())

    for i in range(N, M+1):
        if is_Prime[i]:
            print(i)