//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 192 👎 0

class 顺时针打印矩阵 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int rows = matrix.length, columns = matrix[0].length;
            int[] order = new int[rows * columns];
            int index = 0;
            int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
            while (left <= right && top <= bottom) {
                //打印上面那一行
                for (int column = left; column <= right; column++) {
                    order[index++] = matrix[top][column];
                }
                //打印右边那一列
                for (int row = top + 1; row <= bottom; row++) {
                    order[index++] = matrix[row][right];
                }
                if (left < right && top < bottom) {
                    // 打印底部那一行
                    for (int column = right - 1; column > left; column--) {
                        order[index++] = matrix[bottom][column];
                    }
                    // 打印左侧那一列
                    for (int row = bottom; row > top; row--) {
                        order[index++] = matrix[row][left];
                    }
                }
                left++;
                right--;
                top++;
                bottom--;
            }
            return order;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 顺时针打印矩阵().new Solution();
    }
}