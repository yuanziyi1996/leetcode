//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 251 👎 0

class 矩阵中的路径 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int n = board[0].length;
            int m = board.length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(i, j, m, n, 0, word, board)) {
                        return true;
                    }
                }

            }
            return false;
        }

        public boolean dfs(int m, int n, int maxRow, int maxClo, int index, String word, char[][] board) {
            if (m >= maxRow || n >= maxClo || m < 0 || n < 0 || word.charAt(index) != board[m][n]) {
                return false;
            }

            // 上一条语句已经判定 word.charAt(index) != board[m][n]
            // 所以这一行必然是true
            if (index == word.length() - 1) {
                return true;
            }
            char temp =  board[m][n];
            board[m][n] = '*';

            index++;
            boolean res = dfs(m, n - 1, maxRow, maxClo, index, word, board) ||
                    dfs(m, n + 1, maxRow, maxClo, index, word, board) ||
                    dfs(m - 1, n, maxRow, maxClo, index, word, board) ||
                    dfs(m + 1, n, maxRow, maxClo, index, word, board);
            board[m][n] = word.charAt(index);
            if(!res){
                board[m][n] = temp;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 矩阵中的路径().new Solution();
        char[][] board = { {'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
        ;

    }
}