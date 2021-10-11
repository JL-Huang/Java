package DeepList;
//双向链表LinkList的java实现


public class 双向链表LinkList的java实现 {
//	头指针与尾指针
	private Node first;
	private Node last;
	private static int size;
	public static void main(String[] args) {
	双向链表LinkList的java实现 s=new 双向链表LinkList的java实现();
	s.addtail("2");
	s.addtail("4");
	s.addtail("6");
	for(int i=0;i<size;i++) {
	System.out.print(s.get(i).object);
	}
//	稍微注意一下，这里测试时一定要一段一段分别测试，因为删了以后会改变s的属性
//	s.delete(1);
//	for(int i=0;i<size;i++) {
//	System.out.print(s.get(i).object);
//	}
	s.addmiddle(8, 0);
	for(int i=0;i<size;i++) {
	System.out.print(s.get(i).object);
	}
	
	}

			
//	实现链表的增操作
//	尾插法，每次增的内容在链表尾部
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
//			这里把指针设为null表示尾指针的后指针不指向头指针，否则会出现索引超维度仍指向头指针的问题
//			踩了个大坑，这两行是非常重要的，后面对第一位的操作都要考虑下面这两行代码
			node.next=first;
			first.previous=node;
		}
		size++;
	}
//	中间插入节点,注意由于标索引的习惯，这里的插入是再某个节点前面插入,不讨论空链表的情况
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
//	实现链表的查操作
//	注意这是最直观的方法，算法还有很大的优化空间
	public Node get(int index) {
		if(index<0 || index>size-1) {
//			抛出异常后不用再return
			throw new RuntimeException("索引超出维度"+"："+index);
			
		}else {
			Node node=first;
			for(int i=0;i<index;i++) {
				node=node.next;
			}
			return node;
		}

	}
//	实现链表的删操作
//	首先得获取这个节点，用刚写好的查方法
	public void delete(int index) {
		Node node=get(index);
		node.previous.next=node.next;
		node.next.previous=node.previous;
		size--;
	}
	
	
	
//	这个内部类定义了Node类，事实上java的链表是通过Node类实例化实现了指针的功能
	 class Node{
		Node previous;
		Node next;
		Object object=new Object();
		public Node() {
			
		}
//		这个构造方法使用时必须输入前指针后指针参数
		public Node(Node previous, Node next, Object object) {
			super();
			this.previous = previous;
			this.next = next;
			this.object = object;
		}
//		这个构造方法使用时只需输入当前节点内容
		public Node(Object object) {
			super();
			this.object = object;
		}
		
	}
}
