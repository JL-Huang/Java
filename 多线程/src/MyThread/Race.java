package MyThread;

public class Race implements Runnable{
//	����һ�����󣬰�step����˳�Ա������Ȼ��win�޲Σ����Ǵ���ġ�
//	���������߳�ʱ����Ա�����ǹ���ģ���stepӦ���������߳��Լ������ԲŶ�
	public String winner;
	
	@Override
	public void run() {
		for(int step=0;step<=1000;step++) {

//			���ﻹ���е����⣬��ʱ�����һ���Ѿ�Ӯ�ˣ���һ������ǰ��һ���������ǲ�������
			if(Thread.currentThread().getName()=="����"&&step==10) {
//				�̵߳��쳣ֻ��trycatch������throws
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+step);
//			�����this��Ȼ����ʡ�ԣ����ˣ��������ǷǾ�̬������
			boolean b=this.win(step);
			if(b==true) {
				break; 
			}

			}
		}
	public boolean win(int s) {
//		�����Ǻܹؼ��ģ�winner�ǹ���ı������������Ļ��������һ��������winner�Ѿ���ֵ
//		������һ���������ڼ����ܣ�Ȼ����������ھ�
		if(winner!=null) {
			return true;
		}else {
			if(s==1000) {
				winner=Thread.currentThread().getName();
				System.out.println(winner);
				return true;
			}
		}
		return false;
	}

public static void main(String[] args) {
	Race r=new Race();
	new Thread(r,"����").start();
	new Thread(r,"�ڹ�").start();
	
}
}
