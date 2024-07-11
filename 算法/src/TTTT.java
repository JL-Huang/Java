public class TTTT {
    public static void main(String[] args) {
        DoubleListNode head = DoubleListNode.toDoubleListNode(new int[]{1, 2, 3, 4, 5});
        revertDoubleListNode(head);
    }

    public static DoubleListNode revertDoubleListNode(DoubleListNode head) {
        DoubleListNode pre = null;
        DoubleListNode cur = head;
        while (cur != null) {
            DoubleListNode temp = pre;
            pre = cur;
            cur = cur.next;
            if(temp!=null){
                temp.pre = pre;
            }
            pre.next = temp;
            if(cur==null){
                pre.pre=null;
            }
        }
        return pre;
    }

}

class DoubleListNode {
    private int value = -1;
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode(int val) {
        value = val;
    }

    public static DoubleListNode toDoubleListNode(int[] values) {
        DoubleListNode beforeNode = new DoubleListNode(-1);
        DoubleListNode temp = beforeNode;
        for (int i = 0; i < values.length; i++) {
            DoubleListNode node = new DoubleListNode(values[i]);
            temp.next = node;
            node.pre = temp;
            temp = temp.next;
        }
        beforeNode.next.pre = null;
        return beforeNode.next;
    }
}