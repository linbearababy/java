#leetcode 2020/08/22
//正确 时间复杂度O(n^2）
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] address = new int[2];
        for (int i = 0; i < nums.length; i++) {
            //target = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    address[0] = i;
                    address[1] = j;
                    return address;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

//错误解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] address = new int[2];
        for (int i = 0; i < nums.length; i++) {
        //这里会有问题， 后面的 target有问题 会导致找不到答案
            target = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target) {
                    address[0] = i;
                    address[1] = j;
                    return address;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
