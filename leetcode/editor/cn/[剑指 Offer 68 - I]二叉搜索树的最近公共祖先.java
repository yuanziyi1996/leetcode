//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-search-tree/ 
// Related Topics 树 
// 👍 95 👎 0

class 二叉搜索树的最近公共祖先 {
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

    /**
     * 本题给定了两个重要条件：① 树为 二叉搜索树 ，② 树的所有节点的值都是 唯一 的。根据以上条件，可方便地判断 p,qp,q 与 rootroot 的子树关系，即：
     * <p>
     * 若 root.val < p.valroot.val<p.val ，则 pp 在 rootroot 右子树 中；
     * 若 root.val > p.valroot.val>p.val ，则 pp 在 rootroot 左子树 中；
     * 若 root.val = p.valroot.val=p.val ，则 pp 和 rootroot 指向 同一节点 。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 迭代方式
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //递归方式
            return lowestCommonAncestor_recursion(root, p, q);

            //迭代方式
//            return lowestCommonAncestor_iteration(root, p, q);
        }

        /**
         * 迭代方式
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor_iteration(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                {
                    root = root.right; // 遍历至右子节点
                } else if (root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                {
                    root = root.left; // 遍历至左子节点
                } else {
                    break;
                }
            }
            return root;
        }

        //递归方式
        public TreeNode lowestCommonAncestor_recursion(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) {
                return null;
            }
            return dfs(root, p, q);
        }

        public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > p.val && root.val > q.val) {
                return dfs(root.left, p, q);
            }
            if (root.val < p.val && root.val < q.val) {
                return dfs(root.right, p, q);
            }
            return root;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉搜索树的最近公共祖先().new Solution();
    }
}