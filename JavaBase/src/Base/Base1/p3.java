package Base.Base1;
//返回质数
public class p3 {
	public static void main(String[] args) {
		outer:for(int i=1;i<150;i++) {
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					continue outer;//不能改成break，break跳出所有循环
				}

			}
			System.out.println(i);
		}
	}
}
