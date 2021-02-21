//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 118 👎 0

class 二叉搜索树的第k大节点 {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 中序遍历 左，根，右
         * 中序遍历逆序 右，根，左
         * 中根遍历的逆向顺序是一个递增序列，此题就是找到中根序列的第k大节点
         *
         * @param root
         * @param k
         * @return
         */
        int res = 0, index = 0;

        public int kthLargest(TreeNode root, int k) {
            if (root == null || k < 0) {
                return 0;
            }
            dfs(root, k);
            return res;
        }

        public void dfs(TreeNode root, int k) {
            if (root == null) {
                return;
            }
            //中序的逆序，所以右子树放在最前面
            dfs(root.right, k);
            index = index + 1;
            if (index == k) {
                res = root.val;
            }
            dfs(root.left, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉搜索树的第k大节点().new Solution();
    }
}