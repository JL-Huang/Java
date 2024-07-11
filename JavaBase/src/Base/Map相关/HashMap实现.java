package Base.Map相关;
//HashMap 实现
//插播一个HashTable,与HashMap基本一模一样，但是是线程安全的，效率低，不允许key与value为null
//上面三个特点与HashMap正好相反
public class HashMap实现<K,V> {
//	这里有点绕，Node应该对应的是Entry，一个Node节点封装了key，value等的信息，以链表形式存放在数组中
//	但是这里写成Node[]，链表又成了数组的形式，即用数组实现链表……很迷,所以我注释掉了，没有用这个方法
//	Node[] table=new Node[16];
//	一个位桶的长度，即默认链表数为16，一般都是二的整数次幂
//	好了我明白是怎么回事了，确实是由Node构成了一个数组，但一个数组成员是多个Node，他们有共同的hash值
//	注意不能写成内部类，不然是无法作为成员变量的
	Node[] table=new Node[16];
	public static void main(String[] args) {
		HashMap实现<Integer,String> s=new HashMap实现();
		s.put(1,"one");
		s.put(2, "two");
		s.put(3, "three");
		s.put(19, "hhh");
		s.put(3, "jjj");
		s.check(14);
		s.put(4, "four");
		
		
		
	}
//哈希表的增操作
	 public void put(K k,V v) {
		 Node node=new Node();//这是加进去的节点
		 Node temp=new Node();//这是用来遍历的辅助节点
		 Node lastnode=new Node();//这是用来保存链表最后一位
		 boolean need=true;
		 node.key=k;
		 node.value=v;
		 int hashCode1=k.hashCode();
		 node.hushvalue=hashCode1&(table.length-1);
//		 System.out.println(node.hushvalue);
		 node.next=null;
		 if(table[node.hushvalue]==null) {
			 table[node.hushvalue]=node;
		 }else {
//		这里有点复杂，当数组这一位不为空就要用指针遍历这个链表看是否有key重复
			 temp=table[node.hushvalue];
			 while(temp!=null) {
//				 temp=temp.next;
				 if(temp.key.equals(k)) {
//		判断到键重复，把值覆盖就行，因为直接替换还要处理指针问题。把need变成false
					 need=false;
					 temp.value=node.value;
					 
					 break;
				 }else {
//		这里是关键之处了，遍历的每一位都会存到lastNode不断更新
//		 当遍历到最后一位，temp.next为空，会跳出while循环,但是最后一位已经保存在了lastnode中
//		 这里还涉及到ifelse的一个问题，即else里面经过操作满足了if的条件，也不会再执行if语句
					 lastnode=temp;
					 temp=temp.next;
				 }
			 }
			lastnode.next=node;
		 }
//		 这里还有一个问题，当键重复时是不需要把新链表元素加到最后的，所以要加一个判断
		 if(need==true) {
			 lastnode.next=node;			 
		 }
	 }

	 
//	 哈希表的查操作
	 public void check(K k) {
		 int hashvalue=k.hashCode()&(table.length-1);
		 if(table[hashvalue]==null) {
			 System.out.println("没有");
		 }else {
			 if(table[hashvalue].key.equals(k)) {
				 System.out.println(table[hashvalue].value);
			 }else {
				 Node temp=table[hashvalue];
				 while(temp!=null) {
//					 遍历时查到了，就返回值并跳出
					 if(temp.key==k) {
						 System.out.println(temp.value);
						 break;
					 }
					 temp=temp.next;
//					 如果temp.next为空，说明已经遍历完，还是没有找到，弹出没有
					 if(temp==null) {
						 System.out.println("没有");
					 }
				 }
				 
			 }
		 }
	 }
	

	
}
 class Node{
	int hushvalue;//哈希值，决定了在位桶数组的位置
	Object key;
	Object value;
	Node next;
//	public Node(int hushvalue, Object key, Object value, Node next) {
//		super();
//		this.hushvalue = hushvalue;
//		this.key = key;
//		this.value = value;
//		this.next = next;
	}
	

