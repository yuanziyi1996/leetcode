//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 708 👎 0

class 反转链表_II {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1.找到需要反转链表的前一个尾部节点 left的前一个节点
     * 2.找到需要反转的尾部和头部节点[left, right]的闭合区间
     * 3.找到right 的下一个节点
     * 4.截取中间的部分，此时需要把尾部节点的下个节点置为null
     * 5. 反转链表
     * 6. 将left的前一个节点与反转后的第一个节点拼接，将反转后的末节点和 right的后一个节点拼接。
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) {
                return head;
            }


            ListNode first = new ListNode(-1);
            int count = 1;
            first.next = head;
            ListNode pre = first;
            while (count < left) {
                //记录反转前的最后一个节点。
                pre = head;
                //如果不在循环，则当前head 已经是需要反转的第一个节点了
                head = head.next;
                count++;
            }
            ListNode leftNode = head;
            ListNode rightNode = head;
            while (left <= count && count <= right) {
                rightNode = head;
                head = head.next;
                count++;
            }

            ListNode succ = head;

            //先截取链表,把末尾的那个节点阶段 就OK了
            rightNode.next = null;
            ListNode reversed = reverse(leftNode);

            //拼接左边部分和反转链表的头部
            pre.next = reversed;
            //拼接反转链表尾部部分和右边部分
            leftNode.next = succ;


            return first.next;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null;
            ListNode next = null;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;

            }
            return pre;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new 反转链表_II().new Solution();
        int[] arr = {5};
        ListNode node = ListNode.buildListNode(arr);
//        ListNode node1 = node;
//        System.out.println(node.toString());
//        System.out.println(node1.toString());
//        System.out.println("====");
//        node = node.next;
//        System.out.println(node.toString());
//        System.out.println(node1.toString());
//        System.out.println(solution.reverse(node).toString());
        System.out.println(solution.reverseBetween(node, 1, 1).toString());
    }
}