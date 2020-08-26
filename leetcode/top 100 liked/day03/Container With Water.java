day 03
08/25/2020

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

//Initially we consider the area constituting the exterior most lines. Now, to maximize the area, we need to consider the area between the lines of larger lengths. If we try to move the pointer at the longer line inwards, we won't gain any increase in area, since it is limited by the shorter line. But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width. This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
//遍历每一种方法，找到最大值。水桶问题最重要的是最短的那个边。每次指两个pointer，比较最短的那个，找出面积，然后往后移
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right])*(right - left));
            if (height[left] < height[right]) {
                left ++;
            }
            else if (height[left] >= height[right]) {
                right --;
            }
        }
        return area;
    }
    //     int maxarea = 0, l = 0, r = height.length - 1;
    //     while (l < r) {
    //         maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
    //         if (height[l] < height[r])
    //             l++;
    //         else
    //             r--;
    //     }
    //     return maxarea;
    // }
}
