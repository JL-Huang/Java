package Base;

public class p7 {

	public static void main(String[] args) {
		Test test=new Test();
		test.k(1, 1, "1", "1");
//		基本数据类型用==比较值
//		引用数据类型用==比较地址
		if(test.i1==test.i2) {
			System.out.println("==");
		}
		if(test.s1.equals(test.s2)) {
			System.out.println("equals");
		}
	}
}
class Test{
	int i1;
	int i2;
	String s1;
	String s2;
	public void k(int i1,int i2,String s1,String s2) {
		this.i1=i1;
		this.i2=i2;
		this.s1=s1;
		this.s2=s2;
		System.out.println("fafa");
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i1;
		result = prime * result + i2;
		result = prime * result + ((s1 == null) ? 0 : s1.hashCode());
		result = prime * result + ((s2 == null) ? 0 : s2.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (i1 != other.i1)
			return false;
		if (i2 != other.i2)
			return false;
		if (s1 == null) {
			if (other.s1 != null)
				return false;
		} else if (!s1.equals(other.s1))
			return false;
		if (s2 == null) {
			if (other.s2 != null)
				return false;
		} else if (!s2.equals(other.s2))
			return false;
		return true;
	}
		
	
}