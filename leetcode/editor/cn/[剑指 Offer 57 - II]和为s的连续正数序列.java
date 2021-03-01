//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 210 👎 0

import java.util.ArrayList;
import java.util.List;

class 和为s的连续正数序列 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int i = 1; // 滑动窗口的左边界
            int j = 1; // 滑动窗口的右边界
            int sum = 0; // 滑动窗口中数字的和
            List<int[]> res = new ArrayList<>();
            while (i <= target / 2) {
                if (sum < target) {
                    sum += j;
                    j++;
                } else if (sum > target) {
                    sum -= i;
                    i++;
                } else {
                    System.out.println("j : " + j + " , i :" + i);
                    int[] arr = new int[j - i];
                    for (int k = i; k < j; k++) {
                        arr[k - i] = k;
                    }
                    res.add(arr);
                    //因为要向left右边移动，所以把当前加上的left向左边移动
                    sum -= i;
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 和为s的连续正数序列().new Solution();
    }
}