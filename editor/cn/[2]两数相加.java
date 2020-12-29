//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Stack;

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
class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        //设置进位 = 0
        int added = 0;
        while (added ==1 || l1 != null || l2 != null) {
            //分别取节点 1 ，节点 2的值
            int vall1 = l1 != null ? l1.val : 0;
            int vall2 = l2 != null ? l2.val : 0;
            int sum = (vall1 + vall2 + added) % 10;
            added = (vall1 + vall2 + added) >= 10 ? 1 : 0;
            result.next = new ListNode(sum);
            result = result.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode res = addTwoNumbers(node1, node2);
        System.out.println(res.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
