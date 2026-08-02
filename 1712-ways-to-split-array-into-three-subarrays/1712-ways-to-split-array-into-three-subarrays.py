class Solution:
    def waysToSplit(self, nums: list[int]) -> int:
        n = len(nums)
        MOD = 10**9 + 7
        
        # Step 1: Build the prefix sum array (exactly like before)
        prefix = [0] * n
        prefix[0] = nums[0]
        for k in range(1, n):
            prefix[k] = prefix[k-1] + nums[k]
            
        res = 0
        
        # Our two pointers for the Mid array boundaries
        j_min = 1
        j_max = 1
        
        # Step 2: Iterate 'i', which marks the end of the Left array
        for i in range(n - 2):
            
            # Early exit: If Left is > 1/3 of the total sum, we can't split it validly anymore
            if prefix[i] * 3 > prefix[-1]:
                break
                
            # Make sure j_min stays ahead of i
            j_min = max(j_min, i + 1)
            
            # Slide j_min right until Left <= Mid
            # (Prefix sum math: prefix[j_min] >= 2 * prefix[i])
            while j_min < n - 1 and prefix[j_min] < 2 * prefix[i]:
                j_min += 1
                
            # Make sure j_max stays at least where j_min is
            j_max = max(j_max, j_min)
            
            # Slide j_max right as long as Mid <= Right
            # (Prefix sum math: 2 * prefix[j_max] <= prefix[-1] + prefix[i])
            while j_max < n - 1 and 2 * prefix[j_max] <= prefix[-1] + prefix[i]:
                j_max += 1
                
            # The number of valid ways to place the end of Mid is the gap between the pointers
            if j_min < j_max:
                res = (res + (j_max - j_min)) % MOD
                
        return res