if __name__ == '__main__':
    T = int(input())

    for _ in range(T):

        H, W, N = map(int, input().split())

        if N%H == 0:
            floor = H
        else:
            floor = N%H

        room = (N-1) // H + 1

        print(floor, end = "")
        if room < 10:
            print("0", end="")

        print(room)