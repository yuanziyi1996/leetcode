//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 95 👎 0

import common.ListNode;

class 从尾到头打印链表 {
         //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if(head == null){
            return new int[0];
        }
        int count = 0;
        // 当前节点的前一个节点
        ListNode pre = null;

        // 当前节点的下一个节点
        ListNode next = null;
        while (head.next!=null){
            // 记录当前节点的下一个节点位置；
            next = head.next;
            // 让当前节点指向前一个节点位置，完成反转
            head.next = pre;
            // pre 往右走
            pre = head;
            // 当前节点往右继续走
            head = next;
            count++;
        }
        int [] res = new int[count];
        int i = 0;
        while (head.next!=null){
            res[i++] = head.val;
            head =head.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 从尾到头打印链表().new Solution();
    }
}