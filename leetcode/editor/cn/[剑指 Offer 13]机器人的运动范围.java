//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 216 👎 0

class 机器人的运动范围 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m, n, k, visited);
        }

        public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
            if (i >= m || j >= n) {
                return 0;
            }
            if (visited[i][j]) {
                return 0;
            }
            if (get(i) + get(j) > k) {
                return 0;
            }

            visited[i][j] = true;

            return dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + 1;
        }

        private int get(int x) {
            int res = 0;
            while (x != 0) {
                res += x % 10;
                x /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 机器人的运动范围().new Solution();
        solution.movingCount(1,2,1);
    }
}