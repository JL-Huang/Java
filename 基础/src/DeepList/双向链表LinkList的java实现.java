package DeepList;
//˫������LinkList��javaʵ��


public class ˫������LinkList��javaʵ�� {
//	ͷָ����βָ��
	private Node first;
	private Node last;
	private static int size;
	public static void main(String[] args) {
	˫������LinkList��javaʵ�� s=new ˫������LinkList��javaʵ��();
	s.addtail("2");
	s.addtail("4");
	s.addtail("6");
	for(int i=0;i<size;i++) {
	System.out.print(s.get(i).object);
	}
//	��΢ע��һ�£��������ʱһ��Ҫһ��һ�ηֱ���ԣ���Ϊɾ���Ժ��ı�s������
//	s.delete(1);
//	for(int i=0;i<size;i++) {
//	System.out.print(s.get(i).object);
//	}
	s.addmiddle(8, 0);
	for(int i=0;i<size;i++) {
	System.out.print(s.get(i).object);
	}
	
	}

			
//	ʵ�������������
//	β�巨��ÿ����������������β��
	public void addtail(Object o) {
		Node node=new Node(o);
		if(first==null) {
			first=node;
			last=node;
			node.next=null;
			node.previous=null;
		}else {
			node.previous=last;
			last.next=node;
			last=node;
//			�����ָ����Ϊnull��ʾβָ��ĺ�ָ�벻ָ��ͷָ�룬��������������ά����ָ��ͷָ�������
//			���˸���ӣ��������Ƿǳ���Ҫ�ģ�����Ե�һλ�Ĳ�����Ҫ�������������д���
			node.next=first;
			first.previous=node;
		}
		size++;
	}
//	�м����ڵ�,ע�����ڱ�������ϰ�ߣ�����Ĳ�������ĳ���ڵ�ǰ�����,�����ۿ���������
	public void addmiddle(Object o,int index) {
		Node node=get(index);
		Node newnode=new Node();
		Node h=node.previous;
		newnode.object=o;
		newnode.previous=node.previous;
		h.next=newnode;
		newnode.next=node;
		node.previous=newnode;
		size++;
		
	}
//	ʵ������Ĳ����
//	ע��������ֱ�۵ķ������㷨���кܴ���Ż��ռ�
	public Node get(int index) {
		if(index<0 || index>size-1) {
//			�׳��쳣������return
			throw new RuntimeException("��������ά��"+"��"+index);
			
		}else {
			Node node=first;
			for(int i=0;i<index;i++) {
				node=node.next;
			}
			return node;
		}

	}
//	ʵ�������ɾ����
//	���ȵû�ȡ����ڵ㣬�ø�д�õĲ鷽��
	public void delete(int index) {
		Node node=get(index);
		node.previous.next=node.next;
		node.next.previous=node.previous;
		size--;
	}
	
	
	
//	����ڲ��ඨ����Node�࣬��ʵ��java��������ͨ��Node��ʵ����ʵ����ָ��Ĺ���
	 class Node{
		Node previous;
		Node next;
		Object object=new Object();
		public Node() {
			
		}
//		������췽��ʹ��ʱ��������ǰָ���ָ�����
		public Node(Node previous, Node next, Object object) {
			super();
			this.previous = previous;
			this.next = next;
			this.object = object;
		}
//		������췽��ʹ��ʱֻ�����뵱ǰ�ڵ�����
		public Node(Object object) {
			super();
			this.object = object;
		}
		
	}
}
