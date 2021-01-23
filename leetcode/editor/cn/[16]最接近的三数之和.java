//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 664 👎 0

import java.util.Arrays;

class 最接近的三数之和 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (Math.abs(target - sum) < Math.abs(target - ans)) {
                        ans = sum;
                    }
                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        return ans;
                    }

                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 最接近的三数之和().new Solution();
        int [] nums = {-1,2,1,-4};
        int res = solution.threeSumClosest(nums,2);
        System.out.println(res);
    }
}