class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while(left < right) {
            // Calculate current water
            int water = Math.min(height[left], height[right]) 
                        * (right - left);
            
            maxWater = Math.max(maxWater, water);
            
            // Move smaller height pointer
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}