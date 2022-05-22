class Solution:
    def trap(self, height: List[int]) -> int:
        if(len(height)==1 or len(height)==2):
            return 0
        stack=[]
        count1,count2,i=0,0,0
        maxIndex=height.index(max(height))
        
        while(height[i]<=0):
            i+=1
        curr_max=i
        for i in range(curr_max,maxIndex+1,1):
            if(height[i]>=height[curr_max]):
                curr_max=i
                while(len(stack)>0):
                    t=stack.pop()
                    count1=count1+t
            elif(height[i]<height[curr_max]):
                stack.append(height[curr_max]-height[i])
            
        i=len(height)-1
        
        while(height[i]<=0):
            i-=1
        curr_max=i
        for i in range(curr_max,maxIndex-1,-1):
            if(height[i]>=height[curr_max]):
                curr_max=i
                while(len(stack)>0):
                    count2=count2+stack.pop()
            elif(height[i]<height[curr_max]):
                stack.append(height[curr_max]-height[i])
                
        return count1+count2
