package ArrayTest;

import java.util.Arrays;

//����
public class p10 {
public static void main(String[] args) {
//	��̬��ʼ��
	 pp10[] p= {new pp10(1,"one"),new pp10(2,"two")};
//	 ��ӡ�����һ�ַ�����forѭ��
	for(int i=0;i<p.length;i++) {
		System.out.println(p[i].name);
	}
//	Ĭ�ϳ�ʼ��
	int[] i3=new int[3];
//	��ӡ����ڶ��ַ���������Array��
	System.out.println(Arrays.toString(i3));
//	��̬��ʼ��
	String[] str3=new String[3];
	str3[0]="zero";
	str3[1]="one";
	str3[2]="two";
//	��ӡ��������ַ���foreach��ֻ�ܶ����ܸ�
	for(String n:str3) {
		System.out.println(n);
	}
			
}
 static class pp10{
	int id;
	String name;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public pp10(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
}
