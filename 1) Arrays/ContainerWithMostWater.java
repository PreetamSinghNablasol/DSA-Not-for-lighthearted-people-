// two pointer traversal technique
class Solution 
{
    public int maxArea(int[] height) 
    {
        int first=0, last=height.length-1, max=0, temp =0;
        while(first<last)
        {
            if(height[last] > height[first])
            {
                temp = (last - first)*height[first];
                first++;
            }
            else 
            {
                temp = (last - first)*height[last];
                last--;
            }
            if(max < temp)
            {
                max = temp;
            }
        }
        return max;
    }
}