package 树;
//这个类是引用专题
public class Reference {
	public static void main(String[] args) {
		Reference reference=new Reference();
		reference.StringBufferReference();
	}
	public void StringBufferReference() {
		StringBuffer sb1=new StringBuffer();
		sb1.append(1);
		StringBuffer sb2=sb1;
		sb2=new StringBuffer();
		sb1.append(2);
//		sb1=sb2;
		System.out.println(sb1);
		System.out.println(sb2);
	}
}
