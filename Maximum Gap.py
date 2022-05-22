class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        if(len(nums)==1):
            return 0
        maximum=0
        nums.sort()
        for i in range(0,len(nums)-1):
            dif=nums[i+1]-nums[i]
            if(dif>maximum):
                maximum=dif
        return maximum
