import tree.TreeUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author ziyi.yuan
 * @date 2021/1/23 6:02 下午
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 层序遍历数组 重建二叉树
     *
     * @param numbers
     * @return
     */
    public static TreeNode rebuildTree(Integer[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        int length = numbers.length;
        TreeNode root = new TreeNode(numbers[0]);
        if (length == 1) {
            return root;
        }
        createFullBT_DFS(root, numbers, length, 1);
        return root;
    }


    /**
     * 层次遍历二叉树 ，包括null的节点
     * @param root
     * @return
     */
    public static Integer[] levelOrder(TreeNode root) {
        int maxDepth = maxDepth(root);
//        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new Integer[0];
        }
        Integer[] arr = new Integer[(1 << maxDepth) -1];
        Queue<TreeNode> queue = new LinkedList();
        Queue<Integer> index = new LinkedList<>();
        queue.add(root);
        index.add(0);
        //记录哪些index 不是null
        Set<Integer> set = new HashSet<>();
        set.add(0);
        arr[0] = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                Integer idx = index.poll();
//                res.add(node.val);
                set.add(idx);
                if (node.left != null) {
                    queue.add(node.left);
                    index.add(2 * idx + 1);
                    arr[2 * idx + 1]= node.left.val;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    index.add(2 * idx + 2);
                    arr[2 * idx + 2]= node.right.val;
                }
            }
        }
//        System.out.println("有值的节点的索引位置 :"+set);
//        System.out.println(Arrays.toString(arr) + "length :" + arr.length);
        return arr;
    }

    public static void printTree(TreeNode node){
        Integer[] res = levelOrder(node);
        TreeUtils.printTree(res);
    }


    public static void main(String[] args) {
        TreeNode node = rebuildTree(new Integer[]{7, 4, 9, 2, 5, 8, 11, 1, 3, null, 6, null, null, 10, 12
                , 2, 3, 4, 5, null, null, 7, 8, null, null, null, null, 5, 5, 7, 7});
        Integer[] res = levelOrder(node);
        TreeUtils.printTree(res);
    }

    public static void createFullBT_DFS(TreeNode root, Integer numbers[], int len, int i) {
        if (i <= len) {
            if (2 * i <= len && numbers[2 * i - 1] != null) {
                root.left = new TreeNode(numbers[2 * i - 1]);
                createFullBT_DFS(root.left, numbers, len, 2 * i);
            }
            if ((2 * i + 1) <= len && numbers[2 * i] != null) {
                root.right = new TreeNode(numbers[2 * i]);
                createFullBT_DFS(root.right, numbers, len, 2 * i + 1);
            }
        }
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
