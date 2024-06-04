import bisect
from typing import List


class Solution:
    def install_router(self, lst: List[int], C: int) -> int:

        lst.sort()

        low = 1 # 라우터간 최솟값은 1
        high = lst[-1] - lst[0] # 라우터간 최대값은 양 끝값의 거리
        min_gap = 0

        while low <= high:
            mid = (low + high) // 2

            # 공유기 설치 개수 & 현재 공유기 위치
            cnt = 1
            cur = lst[0]

            for idx in range(1, len(lst)):
                if lst[idx] >= cur + mid:
                    cnt += 1
                    cur = lst[idx]

            # 공유기 거리가 mid 일때 설치된 공유기 수가 n을 만족한다면
            if cnt >= C:
                min_gap = mid
                low = mid + 1
            else:
                high = mid - 1

        return min_gap


if __name__ == '__main__':
    s = Solution()

    N, C = input().split(" ")

    lst = []

    for _ in range(int(N)):
        temp = int(input())
        lst.append(temp)

    print(s.install_router(lst, int(C)))
