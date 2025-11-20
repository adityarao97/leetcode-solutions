class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        #intuition : we keep a map of each character and the last index it occurs, we use an end variable to identify the max index of each character within a partition and we calculate the size of partition using size which is a simple traversal of the string, if we reach that index we append it to result, then we reset the size variable
        lastIndexMap = {}
        for i, ch in enumerate(s):
            lastIndexMap[ch] = i
        res = []
        size, end = 0, 0
        for i, ch in enumerate(s):
            size += 1
            end = max(end, lastIndexMap[ch])
            if i == end:
                res.append(size)
                size = 0
        return res