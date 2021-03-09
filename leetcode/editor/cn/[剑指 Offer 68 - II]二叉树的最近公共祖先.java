//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-tree/ 
// Related Topics 树 
// 👍 192 👎 0

class 二叉树的最近公共祖先 {
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
         * 若 rootroot 是 p, qp,q 的 最近公共祖先 ，则只可能为以下情况之一：
         * <p>
         * pp 和 qq 在 rootroot 的子树中，且分列 rootroot 的 异侧（即分别在左、右子树中）；
         * p = rootp=root ，且 qq 在 rootroot 的左或右子树中；
         * q = rootq=root ，且 pp 在 rootroot 的左或右子树中；
         * <p>
         * <p>
         * 考虑通过递归对二叉树进行后序遍历，当遇到节点 pp 或 qq 时返回。从底至顶回溯，当节点 p, qp,q 在节点 rootroot 的异侧时，节点 rootroot 即为最近公共祖先，则向上返回 rootroot 。
         * <p>
         * 递归解析：
         * 终止条件：
         * 当越过叶节点，则直接返回 nullnull ；
         * 当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
         * 递推工作：
         * 开启递归左子节点，返回值记为 leftleft ；
         * 开启递归右子节点，返回值记为 rightright ；
         * 返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
         * 1.当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
         * 2.当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
         * 3当 left 为空 ，right 不为空 ：p,q 都不在 root的左子树中，直接返回 right 。具体可分为两种情况：
         * p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
         * p,q两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
         * 4当 left 不为空 ， right 为空 ：与情况 3. 同理；
         * <p>
         * <p>
         * 作者：jyd
         * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null && right == null) {
                return null; // 1.
            }
            if (left == null) {
                return right; // 3.
            }
            if (right == null) {
                return left; // 4.
            }
            return root; // 2. if(left != null and right != null)
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 二叉树的最近公共祖先().new Solution();
    }
}