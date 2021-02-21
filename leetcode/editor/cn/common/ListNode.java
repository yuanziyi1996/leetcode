package common;

/**
 * @author ziyi.yuan
 * @date 2020/12/4 4:15 下午
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode newNext(int val){
        ListNode node = this;
        this.next = new ListNode(val);
        return next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(" [ ");
        ListNode node = this;
        while (node != null) {
            if (node.next != null) {
                stringBuilder.append(node.val).append(" -> ");
            } else {
                stringBuilder.append(node.val).append(" ]");
            }
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
