//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2560 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 整数反转 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                //每次取末尾数字
                int tmp = x % 10;
                //判断是否 大于 最大32位整数 max 2147483647
                if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数 min -2147483648
                if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                    return 0;
                }
                res = res * 10 + tmp;
                x /= 10;

            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 整数反转().new Solution();
        System.out.println(2147483648L/1024);
        System.out.println(2097152/1024);
        System.out.println(1<<31);
        System.out.println(1<<31);
        System.out.println("Integer.MAX_VALUE : 2147483647 => "+Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE : "+Integer.MIN_VALUE);
        System.out.println(solution.reverse(-2147483648));
        System.out.println(solution.reverse(-123456));
    }
}