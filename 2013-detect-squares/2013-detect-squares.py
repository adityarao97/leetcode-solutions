class DetectSquares:

    def __init__(self):
        #create a hashmap for faster access of points while checking for a valid square and a list to loop across all points including duplicates 
        self.ptsCount = defaultdict(int)
        self.pts = []        

    def add(self, point: List[int]) -> None:
        self.ptsCount[tuple(point)] += 1
        self.pts.append(point)

    def count(self, point: List[int]) -> int:
        res = 0
        #get the point
        px, py = point
        #loop across all points
        for x, y in self.pts:
            #can't have a square with 0 area or if the length of each side is not equal
            if px == x or py == y or abs(px - x) != abs(py - y):
                continue
            #we've found our diagonal now, but it can be duplicate as well so we want to multiply the count of it
            #for point px, py -> px, y and x, py will be the other two vertices of the square so if they exist we get a square
            res += self.ptsCount[(px, y)] * self.ptsCount[(x, py)]
        return res


# Your DetectSquares object will be instantiated and called as such:
# obj = DetectSquares()
# obj.add(point)
# param_2 = obj.count(point)