class Solution:
    def firstMissingPositive(self, A: List[int]) -> int:
        #mark all negative values to 0
        for i in range(len(A)):
            if A[i] < 0:
                A[i] = 0
        #for each value we want to update at its corresponding index if it falls in the range of the array as negative, 
        #negative value means that index is present in the array, positive means it doesn't
        for i in range(len(A)):
            #we take absolute value as it could've have been negative in the current operation
            val = abs(A[i])
            #check if the value falls in the range
            if 1 <= val <= len(A):
                #we only want to update it, if it's positive, if it's negative it means it has already been updated
                if A[val - 1] > 0:
                    A[val - 1] *= -1
                #for the case where values are 0 we want to update it with - (len(A) + 1) for safely not manipulating the solution
                elif A[val - 1] == 0:
                    A[val - 1] = -1*(len(A) + 1)
        #loop across from 1 to len(A) and if any value is negative it means it exists, if it is positive it doesn't so return it
        for i in range(1, len(A) + 1):
            if A[i - 1] >= 0:
                return i
        return len(A) + 1


