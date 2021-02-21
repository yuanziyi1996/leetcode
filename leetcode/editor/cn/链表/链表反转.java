package 链表;

import common.ListNode;

/**
 * @author ziyi.yuan
 * @date 2021/2/6 9:19 下午
 */
public class 链表反转 {


    public static ListNode reverseList(ListNode node){
        if(node == null){
            return node;
        }
        // 当前节点的前一个节点
        ListNode pre = null;

        // 当前节点的下一个节点
        ListNode next = null;
        //整体是一个大循环
        while (node!=null){
            System.out.println(node.toString());

            // 记录当前节点的下一个节点位置；
            next = node.next;
            // 让当前节点指向前一个节点位置，完成反转
            node.next = pre;
            // pre 往右走
            pre = node;
            // 当前节点往右继续走
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.newNext(2).newNext(3).newNext(4).newNext(5);
        node = reverseList(node);
        System.out.println(node.toString());
    }
}
