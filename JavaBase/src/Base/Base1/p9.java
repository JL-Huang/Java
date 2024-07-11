package Base.Base1;

public class p9 {
	public static void main(String[] args) {
		int a=8,b=6;
		swap(a, b);
		System.out.println(a);
	}
	private static void swap(int a,int b) {
		// TODO Auto-generated method stub
		int temp=a;
		a=b;
		b=a;
	}
}
