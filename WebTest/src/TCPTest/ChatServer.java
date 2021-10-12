package TCPTest;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
//	һ���������˺ܶ��Operation���൱�ڴ���˺ܶ��Socket
	public static CopyOnWriteArrayList<Operation> cup=new CopyOnWriteArrayList<Operation>();
public static void main(String[] args) throws IOException {
	ServerSocket ss=new ServerSocket(8848);
//	���whileѭ������ؼ��ĵط�����Ȼaccept֮���һֱִ����ȥ��������accept��
	while(true) {
		Socket s1=ss.accept();
		System.out.println("һ���ͻ��˴���������");
		Operation c=new Operation(ss, s1);
		cup.add(c);
		new Thread(c).start();
		
	}
}
	
}
class Operation implements Runnable{
	ServerSocket ss;
	Socket s;
	InputStream is;
	DataInputStream dis;
	OutputStream os;
	DataOutputStream dos;
//	Ŀ������
	String name;
	String targetname;
	
	public Operation(ServerSocket ss, Socket s) {
		super();
		this.ss = ss;
		this.s = s;
	}


	@Override
	public void run() {
		boolean isrunning=true;
			try {	
				while(isrunning=true) {
					String data=getin(s);
//					setout(s,data);	
					setoutall(data);	
//					setoutone(data);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isrunning=false;
			}
			release(is,dis,os,dos,s);
			
			

	}
	
	public String getin(Socket s) throws IOException{
		is=s.getInputStream();
		dis=new DataInputStream(is);
		String data=dis.readUTF();
//		�����漸��������Ϊ˽�Ķ��Ƶģ���@�룺�ָ��Ŀ��˽�Ķ���
//		int begin=data.indexOf("@");
//		int end=data.indexOf(":");
//		int f=data.indexOf("��:");
//		this.targetname=data.substring(begin+1, end-1);
//		this.name=data.substring(0,f-1);
		
		return data;
	}
	//����һ����
	public void setout(Socket s,String data) throws IOException {
		os=s.getOutputStream();
		dos=new DataOutputStream(os);
		dos.writeUTF(data);
		dos.flush();
	}
	//����������
	public void setoutall(String data) throws IOException {
//		�����е��ƣ�����cup���飬������������ÿ��OperationԪ�ض�����Socket��Ա����Ӧ��ͻ���
//		����Ҫ���ĵ��õ�ǰoperation��setout�����������ݷ��������Լ���������Operation��Socket
		for(Operation o:ChatServer.cup) {
			if(o==this) {
				continue;
			}else {
				setout(o.s, data);
			}
		}
	}
	//����ָ������
//	public void setoutone(String data) throws IOException {
//
//		for(Operation o:ChatServer.cup) {
//			if(this.targetname.equals(o.name)) {
//				setout(o.s,data);
//			}else {
//				continue;
//			}
//		}
//	}
	
	public void release(Closeable... targets) {
		for(Closeable target:targets) {
			if(target!=null) {
				try {
					target.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
