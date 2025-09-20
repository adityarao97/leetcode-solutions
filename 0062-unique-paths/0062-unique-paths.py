class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        #initialise last row with value as 1 as there will be only 1 possible way to reach finish point
        row = [1] * n
        #for each row except last we want to calculate individual cells value so looping across them
        for i in range(m - 1):
            #initialize current row cell values with 1
            newRow = [1] * n
            for j in range(n-2, -1, -1):
                #loop across each cell in that row from 2nd last and the sum of below and right cell will be its value
                newRow[j] = newRow[j+1] + row[j]
            #update row with newRow
            row = newRow
        #return first cells value
        return row[0]