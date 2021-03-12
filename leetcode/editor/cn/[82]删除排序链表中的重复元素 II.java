//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 469 👎 0

class 删除排序链表中的重复元素_II {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode first = new ListNode(-1);
            ListNode res = first;
            ListNode pre = head;
            head = head.next;
            while (head != null && pre != null) {
                if (pre.val != head.val) {
                    ListNode newNode = new ListNode(pre.val);
                    //走的那个节点 的下一个节点就是 新增的那个节点。
                    first.next = newNode;
                    //走的那个节点向后走，即是把下一个要走的节点 放在 新增的那个节点上。
                    first = first.next;
                    //前置节点往后走
                    pre = pre.next;
                    //当前节点往后走
                    head = head.next;
                } else {
                    //一直把节点向后遍历，知道找到pre的值和当前的值不等，
                    while (pre != null && head != null && pre.val == head.val) {
                        head = head.next;
                    }
                    //当 pre的值和当前的值不等的时候 把pre的节点 指向当前的节点。
                    pre = head;
                    //在当前节点不为空的情况下，把当前节点往后移动一个。
                    if (head != null) {
                        head = head.next;
                    }
                }
            }
            // 例如 1,2,3,3,4,4,5 这种形式，这个情况下，head 已经变成null了，但是pre还是有值存在。
            if (pre != null) {
                ListNode newNode = new ListNode(pre.val);
                first.next = newNode;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 删除排序链表中的重复元素_II().new Solution();
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNode.buildListNode(arr);
        System.out.println(head.toString());
        ListNode res = solution.deleteDuplicates(head);
        if (res == null) {
            System.out.println("返回节点为null");
        } else {
            System.out.println(res.toString());
        }

    }
}