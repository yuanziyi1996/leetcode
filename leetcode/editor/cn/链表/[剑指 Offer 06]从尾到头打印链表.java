package 链表;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
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

import java.util.Stack;

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
        Stack<Integer> stack = new Stack();
        int length = 0;
        while (head != null){
            stack.push(head.val);
            head = head.next;
            length ++;
        }

        int [] res = new int[length];

        int i = 0;
        while (!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }

    /**
     * 使用链表反转 作用
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
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

    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }
        // 当前节点的前一个节点
        ListNode pre = null;

        // 当前节点的下一个节点
        ListNode next = null;
        while (head!=null){
            // 记录当前节点的下一个节点位置；
            next = head.next;
            // 让当前节点指向前一个节点位置，完成反转
            head.next = pre;
            // pre 往右走
            pre = head;
            // 当前节点往右继续走
            head = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.newNext(2).newNext(3).newNext(4).newNext(5);
        System.out.println(head.toString());
        Solution solution = new 从尾到头打印链表().new Solution();
        ListNode res = solution.reverseList(head);
        System.out.println(res.toString());
    }
}