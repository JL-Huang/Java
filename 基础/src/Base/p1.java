package Base;

public class p1 {
	public static void main(String args[]) {
		for(int i=1;i<10;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		int i=0;
		if(i==0) {
			System.out.println("if");
		}else {
			i=i+1;
			i=i-1;
			System.out.println("else");
		}
	}

}
