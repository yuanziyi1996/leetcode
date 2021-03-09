//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 173 👎 0

class 剪绳子 {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 一个数至少可以分成 两个数的和相加，a ,b 我们需要求出a,b成绩最大值，
     * 即使是分成 3个及其以上，（c,d,e)， 其实可以看成是 c,(d+e) 这类情况
     * 必然满足在 两个数的和相加=n 是，肯定存在一个 a, b 使得 a = c 且 b = d+e.
     * 因此我们只需要求出 两个值的最大。
     * 假设 长度 为i, dp[i] 表示i 长度的绳子 切分后乘积最大值。
     * 假设 长度 为i 的绳子可以分成 i ，j-j. 那么两者成绩最大值 为 curr = Math.max( i*(i-j), dp[i-j] * j)；
     * 而dp的值 则必然是 Math.max(curr, dp[i])
     * 因此我们只需要计算  从 1- n 的各个值就行了。
     */
    class Solution {
        public int cuttingRope(int n) {
            int max = 0;
            int dp[] = new int[n+1];
            dp[1] = 1;
            dp[2] = 1;
            //要计算到n 所以必须 i< n+1
            for (int i = 3; i < n+1; i++) {
                //代表减掉的绳子，每一段从 2开始，题目规定 m>1
                // 减掉的绳子还必须小于 当前的总长度 i
                for (int j = 2; j <= i; j++) {
                    int cur = Math.max(j * (i - j), dp[i - j]*j);
                    dp[i] = Math.max(cur, dp[i]);
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 剪绳子().new Solution();
        System.out.println( solution.cuttingRope(44));
    }
}