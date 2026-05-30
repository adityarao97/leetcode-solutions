class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        current = 1
        res = []
        for i in range(len(target)):
            while target[i] > current:
                res.append("Push")
                res.append("Pop")
                current += 1
            if target[i] == current:
                res.append("Push")
                current+= 1
        return res