package Exception���;
//���JDKû�н�����ǵ��쳣�ķ����������Զ����쳣��
//���̳���Exception�࣬�����ܼ���쳣�����������봦��,trycatch����throws
//���̳���RuntimeException,��Ϊ����ʱ�쳣�����������г����ٴ���
//ϰ�����Զ����쳣Ҫ��������������һ��Ĭ�ϣ�һ��������ϸ��Ϣ
public class �Զ����쳣 {
public static void main(String[] args) throws Illegalsex {
	Person person=new Person();
	person.setAge(1);
	person.setSex("��");
}
}
class Person{
	int age;
	String sex;
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
//ֱ��������׳�,ע����throw����throws
		if(age<0) {
			throw new IllegalAge("̫������");
		}
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) throws Illegalsex {
		if(sex!="��" & sex!=" Ů") {
			throw new Illegalsex("����");
		}
		this.sex = sex;
	}
	
}


//����RuntimeException
class IllegalAge extends RuntimeException{
	public IllegalAge() {
		// TODO Auto-generated constructor stub
	}
	IllegalAge(String msg){
	super(msg);
	}
}
//����Exception
class Illegalsex extends Exception{
	public Illegalsex() {
		// TODO Auto-generated constructor stub
	}
//	���ﲻ�Ǻܶ����superд��,�������丸��ֻ��һ������ΪString�ķ�����
	public Illegalsex(String aaa) {
	super(aaa);
	}
}