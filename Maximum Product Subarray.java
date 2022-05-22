class Solution
{
    public int maxProduct(int[] nums)
    {
        int i,temp,res,maximum,minimum;
        res=maximum=minimum=nums[0];
        for(i=1;i<=nums.length-1;i++)
        {
            temp=Math.max(nums[i],Math.max(maximum*nums[i],minimum*nums[i]));
            minimum=Math.min(nums[i],Math.min(maximum*nums[i],minimum*nums[i]));
            maximum=temp;
            if(maximum>res)
                res=maximum;
        }
        
        return res;
    }
}
