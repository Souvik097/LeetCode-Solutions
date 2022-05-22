class Solution
{
    public int largestRectangleArea(int[] heights)
    {
        int i,maxArea;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        maxArea=heights[0];
        int left_smaller[]=new int[heights.length];
        int right_smaller[]=new int[heights.length];
        for(i=0;i<=heights.length-1;i++)
        {
            left_smaller[i]=-1;
            right_smaller[i]=heights.length;
        }
        i=0;
        while(i<=heights.length-1)
        {
            while(!stack.empty() && stack.peek()!=-1 && heights[i]<heights[stack.peek()])
            {
                right_smaller[stack.peek()]=i;
                stack.pop();
            }
            if(i>0 && heights[i]==heights[i-1])
                left_smaller[i]=left_smaller[i-1];
            else
                left_smaller[i]=stack.peek();
            stack.push(i);
            i+=1;
        }
        for(i=0;i<=heights.length-1;i++)
            maxArea=Math.max(maxArea,heights[i]*(right_smaller[i]-left_smaller[i]-1));
            
        return maxArea;
    }
}
