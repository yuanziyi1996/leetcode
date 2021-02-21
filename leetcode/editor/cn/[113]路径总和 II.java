//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 425 👎 0

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 路径总和_II {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            constructPaths(root, targetSum, new ArrayList<Integer>(), res);
            return res;
        }

        public void constructPaths(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> allPath) {
            if (root == null) {
                return;
            }
            //因为list是引用传递，为了防止递归的时候分支污染，我们可以在每个路径
            //中都要新建一个subList

            path.add(root.val);
            if (root.left == null && root.right == null) {
//                System.out.println("子节点：" + root.val);
//                System.out.println(Arrays.asList(temList).toString());
                if (root.val == targetSum) {
                    allPath.add(new ArrayList<>(path));
                    //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
                    //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
                    //一个结点的值给remove掉。
                    System.out.println("结果："+Arrays.asList(path).toString());
                    path.remove(path.size() - 1);
                    return;
                }
            }

            constructPaths(root.left, targetSum - root.val, path, allPath);
            constructPaths(root.right, targetSum - root.val, path, allPath);
            //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
            //我们把这个值使用完之后还要把它给移除，这就是回溯,到了这一步，实际上是求出了一个解了，
            //所以我们需要回溯到上一个节点
            System.out.println("结果2："+Arrays.asList(path).toString());
            path.remove(path.size() - 1);

        }


        /**
         * 如下是第二种方法
         */
        List<List<Integer>> res = new ArrayList<>();
        //这个list 并没有作为方法的参数进行参与迭代
        List<Integer> list = new ArrayList<>();
        public List<List<Integer>> pathSum2(TreeNode root, int sum) {
            dfs(root, 0, sum);
            return res;
        }
        public void dfs(TreeNode root, int num, int sum){
            if(root == null) {
                return;
            }
            num += root.val;
            list.add(root.val);
            if(num == sum && root.left == null && root.right == null) {
                res.add(new ArrayList(list));
            }
            dfs(root.left, num, sum);
            dfs(root.right, num, sum);
            list.remove(list.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 路径总和_II().new Solution();
    }
}