package Map���;
//HashMap ʵ��
//�岥һ��HashTable,��HashMap����һģһ�����������̰߳�ȫ�ģ�Ч�ʵͣ�������key��valueΪnull
//���������ص���HashMap�����෴
public class HashMapʵ��<K,V> {
//	�����е��ƣ�NodeӦ�ö�Ӧ����Entry��һ��Node�ڵ��װ��key��value�ȵ���Ϣ����������ʽ�����������
//	��������д��Node[]�������ֳ����������ʽ����������ʵ������������,������ע�͵��ˣ�û�����������
//	Node[] table=new Node[16];
//	һ��λͰ�ĳ��ȣ���Ĭ��������Ϊ16��һ�㶼�Ƕ�����������
//	��������������ô�����ˣ�ȷʵ����Node������һ�����飬��һ�������Ա�Ƕ��Node�������й�ͬ��hashֵ
//	ע�ⲻ��д���ڲ��࣬��Ȼ���޷���Ϊ��Ա������
	Node[] table=new Node[16];
	public static void main(String[] args) {
		HashMapʵ��<Integer,String> s=new HashMapʵ��();
		s.put(1,"one");
		s.put(2, "two");
		s.put(3, "three");
		s.put(19, "hhh");
		s.put(3, "jjj");
		s.check(14);
		s.put(4, "four");
		
		
		
	}
//��ϣ���������
	 public void put(K k,V v) {
		 Node node=new Node();//���Ǽӽ�ȥ�Ľڵ�
		 Node temp=new Node();//�������������ĸ����ڵ�
		 Node lastnode=new Node();//�������������������һλ
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
//		�����е㸴�ӣ���������һλ��Ϊ�վ�Ҫ��ָ�������������Ƿ���key�ظ�
			 temp=table[node.hushvalue];
			 while(temp!=null) {
//				 temp=temp.next;
				 if(temp.key.equals(k)) {
//		�жϵ����ظ�����ֵ���Ǿ��У���Ϊֱ���滻��Ҫ����ָ�����⡣��need���false
					 need=false;
					 temp.value=node.value;
					 
					 break;
				 }else {
//		�����ǹؼ�֮���ˣ�������ÿһλ����浽lastNode���ϸ���
//		 �����������һλ��temp.nextΪ�գ�������whileѭ��,�������һλ�Ѿ���������lastnode��
//		 ���ﻹ�漰��ifelse��һ�����⣬��else���澭������������if��������Ҳ������ִ��if���
					 lastnode=temp;
					 temp=temp.next;
				 }
			 }
			lastnode.next=node;
		 }
//		 ���ﻹ��һ�����⣬�����ظ�ʱ�ǲ���Ҫ��������Ԫ�ؼӵ����ģ�����Ҫ��һ���ж�
		 if(need==true) {
			 lastnode.next=node;			 
		 }
	 }

	 
//	 ��ϣ��Ĳ����
	 public void check(K k) {
		 int hashvalue=k.hashCode()&(table.length-1);
		 if(table[hashvalue]==null) {
			 System.out.println("û��");
		 }else {
			 if(table[hashvalue].key.equals(k)) {
				 System.out.println(table[hashvalue].value);
			 }else {
				 Node temp=table[hashvalue];
				 while(temp!=null) {
//					 ����ʱ�鵽�ˣ��ͷ���ֵ������
					 if(temp.key==k) {
						 System.out.println(temp.value);
						 break;
					 }
					 temp=temp.next;
//					 ���temp.nextΪ�գ�˵���Ѿ������꣬����û���ҵ�������û��
					 if(temp==null) {
						 System.out.println("û��");
					 }
				 }
				 
			 }
		 }
	 }
	

	
}
 class Node{
	int hushvalue;//��ϣֵ����������λͰ�����λ��
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
	

