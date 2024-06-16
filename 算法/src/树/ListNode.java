package 树;

public class ListNode {
    public int val;
    public ListNode next = null;

    //    ListNode(int val) {
//        this.val = val;
//    }
    public static void main(String[] args) {
        toListNode(new int[]{1, 2, 3, 4});
    }

    public static ListNode toListNode(int[] nums) {
        ListNode node = new ListNode();
        ListNode head = node;
        for (int i = 0; i < nums.length; i++) {
            node.val = nums[i];
            if (node != null) {
                node.next = new ListNode();
                node = node.next;
            }
        }
        return head;
    }
}
