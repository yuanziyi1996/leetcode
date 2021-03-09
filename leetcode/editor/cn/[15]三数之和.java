//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2904 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 三数之和 {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * system.out outofmemory, 超时
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            Arrays.sort(nums);
            if (len < 3) {
                return res;
            }
            // [-4,-1,-1,0,2,4]
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                int left = i + 1;
                int right = len - 1;
                //这里是当 指针到下一位了是时候，需要校验和前一位是否一样，如果一样，则和上一次处理结果一样，就忽略
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                while (left < right) {

                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

        Solution solution = new 三数之和().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
        int[] nums2 = {-1, 0, 1, 2, -1, -4, -2};
        System.out.println(threeSum_of_target(nums2, 1));
    }

    public static List<List<Integer>> threeSum_of_target(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (len < 3) {
            return res;
        }
        // [-4,-1,-1,0,2,4]
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            //这里是当 指针到下一位了是时候，需要校验和前一位是否一样，如果一样，则和上一次处理结果一样，就忽略
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }
            }
        }
        return res;
    }
}