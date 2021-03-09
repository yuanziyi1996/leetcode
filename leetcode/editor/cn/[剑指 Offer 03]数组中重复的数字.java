//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 292 👎 0

import java.util.HashSet;
import java.util.Set;

class 数组中重复的数字 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            return method_swap(nums);
        }

        /**
         * 数组交换法
         * 1. 将数组从头到尾遍历
         * 2. 位置 i 上对应的值应该是 i,如果不是i, 那么就将i 位置上对应的值 cur 作为交换的 下标，
         *    将i位置上的值和num[cur]交换, 直到相等
         * 3. 如果 i位置上的值 和 nums[nums[i]] 相等。
         * @param nums
         * @return
         */
        public int method_swap(int[] nums) {
            int len = nums.length;
            if (len < 0) {
                return 0;
            }
            for (int i = 0; i < len; i++) {
                while (nums[i] != i) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                }
            }
            return -1;
        }

        public int method_iteration(int nums[]) {
            int len = nums.length;
            if (len < 0) {
                return 0;
            }
            int res = -1;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                if (set.contains(nums[i])) {
                    res = nums[i];
                    break;
                } else {
                    set.add(nums[i]);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 数组中重复的数字().new Solution();
    }
}