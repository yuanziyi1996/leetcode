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

    public static ListNode buildListNode(int[] arr) {
        ListNode node = new ListNode(-1);
        ListNode first = node;
        for (int i = 0; i < arr.length; i++) {
            ListNode node1 = new ListNode(arr[i]);
            node.next = node1;
            node = node1;
        }
        return first.next;
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode node = buildListNode(arr);
        System.out.println(node.toString());
    }
}
