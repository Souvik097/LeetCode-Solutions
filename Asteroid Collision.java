class Solution
{
    public int[] asteroidCollision(int[] asteroids)
    {
        int i;
        Stack<Integer> stack=new Stack<>();
        for(i=0;i<=asteroids.length-1;i++)
        {
            if(stack.empty())
                stack.push(asteroids[i]);
            else if(asteroids[i]>0)
                stack.push(asteroids[i]);
            else if(asteroids[i]<0 && stack.peek()<0)
                stack.push(asteroids[i]);
            else if(asteroids[i]<0)
            {
                while(!stack.empty() && stack.peek()>0 && Math.abs(asteroids[i])>stack.peek())
                    stack.pop();
                if(!stack.empty() && stack.peek()>0 && Math.abs(asteroids[i])==stack.peek())
                    stack.pop();
                else if(!stack.empty() && Math.abs(asteroids[i])<stack.peek())
                    continue;
                else
                    stack.push(asteroids[i]);
            }
        }
        int[] res=new int[stack.size()];
        i=res.length-1;
        while(!stack.empty())
        {
            res[i]=stack.pop();
            i-=1;
        }
        
        return res;
    }
}
