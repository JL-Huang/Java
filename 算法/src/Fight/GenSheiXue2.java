package Fight;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GenSheiXue2 {

    public static class Node {

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


/*������������������ʵ����ĿҪ��Ĺ���
��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ 
******************************��ʼд����******************************/
    static Node getCommon(Node headA, Node headB) {
    	Node node1=headA;
    	Node node2=headB;
    	while(node1!=null&&node2!=null) {
    		node1=node1.next;
    		node2=node2.next;
    	}
    	if(node2==null&&node1!=null) {
    		node2=headA;
    		while(node1!=null) {
    			node2=node2.next;
    			node1=node1.next;
    		}
    		node1=headB;
    	}
    	else if(node1==null&&node2!=null) {
    		node1=headB;
    		while(node2!=null) {
    			node2=node2.next;
    			node1=node1.next;
    		}
    		node2=headA;
    	}
    	else if(node1==null&&node2==null) {
    		node1=headA;
    		node2=headB;
    	}
    	while(node1!=null) {
    		if(compare(headA, headB)) return node1;
    		else {
    			node1=node1.next;
    			node2=node2.next;
    		}
    	}
    	return null;

    }
    static boolean compare(Node headA, Node headB) {
    	if(headA!=null&&headB!=null) return false;
    	while(headA!=null||headB!=null) {
    		if((headA!=null&&headB==null)||(headA==null&&headB!=null)) return false;
    		if(headA.data!=headB.data) return false;
    		headA=headA.next;
    		headB=headB.next;
    	}
    	return true;
    }
/******************************����д����******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        Node headA = null;
        Node headB = null;

        Map<String, Node> map = new HashMap<String, Node>();

        if (line1 != null && line1.length() > 0) {
            String[] array1 = line1.split(",");
            headA = new Node();
            headA.setData(Integer.parseInt(array1[0].split("\\(")[0]));
            map.put(array1[0], headA);
            Node pre = headA;
            for (int i = 1; i < array1.length; i++) {
                Node node = map.get(array1[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array1[i].split("\\(")[0]));
                    map.put(array1[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }
        if (line2 != null && line2.length() > 0) {
            String[] array2 = line2.split(",");
            headB = map.get(array2[0]);
            if (headB == null) {
                headB = new Node();
                headB.setData(Integer.parseInt(array2[0].split("\\(")[0]));
                map.put(array2[0], headB);
            }
            Node pre = headB;
            for (int i = 1; i < array2.length; i++) {
                Node node = map.get(array2[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array2[i].split("\\(")[0]));
                    map.put(array2[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }

        Node res = getCommon(headA, headB);
        System.out.println(res == null ? res : res.getData());
    }
}
