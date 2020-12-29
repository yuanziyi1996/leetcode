import java.util.List;

/**
 * @author ziyi.yuan
 * @date 2020/12/4 4:15 下午
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            if (node.next != null) {
                stringBuilder.append(node.val).append(" -> ");
            } else {
                stringBuilder.append(node.val).append(" end ");
            }
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
