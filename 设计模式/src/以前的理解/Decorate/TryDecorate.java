package ��ǰ�����.Decorate;
//������ʵ��ͬһ���ӿڣ�һ�������涨����һ���������Ϊ��Ա��������������Ϊ���췽���Ĳ���
//Ȼ�����Լ��Ľӿڷ�������ó�Ա�����Ľӿڷ�����������и��ֲ������������̾���װ����ģʽ
//1.�����������Ҫװ�εĳ�����󣨽ӿڻ�����ࣩ
//2.�����������Ҫװ�εĶ���
//3.����װ���ࣺ�����˶Գ�������������Լ������Ź��еķ���
//4.���������ࣺ��װ�εĶ���


//				ʵ�ֽӿڣ���дĿ�귽���������Լ�����
//����������ӿڣ��������������������������������������������������������������������������������װ�ε��ࣩ
//		|
//		|
//		|
//		|ʵ�ֽӿڣ����ӿڶ�����Ϊ��Ա��������Ϊ���췽����������дĿ�귽�����ظó�Ա������Ŀ�귽��			
//		|��������������������������������������������������������������������������������������������������������������������������������������������-����������������������������װ����
//																								|
//																								|
//				  �̳г���װ���࣬�Զ���д���췽�����ֶ���дĿ�귽��������superĿ�귽��+�Լ��Ĳ���	|
//		���������ࡪ��������������������������������������������������������������������������������������������������������������������������������������������������������������

//��������ʱ��Ҫ�����ӿڶ���һ���þ�������Ĺ��췽������һ���þ���װ����Ĺ��췽������ǰһ��������Ϊ����
//�����ӵĺô����������̱����ε��༰��Ŀ�귽����û�б��ı䣬��ͨ��װ��ʵ���˿������Կ��������Ŀ�귽�������˱任

public class TryDecorate {
public static void main(String[] args) {
	Drink coffee=new Coffee();
	Drink sugarcoffee=new sugar(coffee);
	System.out.println(sugarcoffee.info()+sugarcoffee.cost());
	Drink tea=new Tea();
	Drink milktea=new milk(tea);
	System.out.println(milktea.info()+milktea.cost());
}
}
//�������,�������һ����һ���ӿڣ�����ķ�����Ŀ�귽�������������̲����Ķ���
interface Drink{
	Double cost();
	String info();
}
//���������������������ж��������֮ͬ��������ʵ����ӿڵķ������ҷ��ص����Լ�������
class Coffee implements Drink{
	private String name="ԭζ����"; 
	private Double price=(double) 10;
	@Override
	public Double cost() {
		return price;
	}

	@Override
	public String info() {
		return name;
	}
	
}
class Tea implements Drink{
	private String name="��"; 
	private Double price=(double) 20;
	@Override
	public Double cost() {
		return price;
	}

	@Override
	public String info() {
		return name;
	}
	
}
//����װ���࣬װ��ģʽ�ĺ�����Ŧ������һ��ʵ���˽ӿڵĳ����࣬�ڳ���װ������������һ���ӿڶ���
//���乹�췽��������˽ӿڶ���Ȼ������д�ӿڷ�����ʵ���˳���������ӿڣ��������ࣨ����+���壩������
abstract class Decorate implements Drink{
	private Drink drink;
	
//		���ع��췽�����βμ�������������
	public Decorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public Double cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}
	
}

//���������ࣨ��װ�ζ���+װ�����ݣ�
//���ñ�װ�ζ�����ͨ��ֱ�����ã�����ͨ���̳г���װ����
//����װ����̳��˳���װ���࣬�Ϳ��Լ������װ�ζ�����
//java�涨�����������˹��췽���������������д�����췽����ʹ�βκͷ���ֵ�븸�����غ�Ĺ��췽��һ��
class milk extends Decorate{

	public milk(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"������ţ��";
	}	
}

class sugar extends Decorate{

	public sugar(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return super.cost()*3;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"��������";
	}
	
	
}