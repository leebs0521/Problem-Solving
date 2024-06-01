def calculate(point: List[int]):
    return point[0] * point[0] + point[1] * point[1]


class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        dists = []
        heap = []

        for point in points:
            dist = calculate(point)
            heapq.heappush(heap, dist)
            dists.append(dist)

        kth_dist = [heapq.heappop(heap) for _ in range(k)][-1]

        return [points[idx] for idx, dist in enumerate(dists) if dist <= kth_dist]