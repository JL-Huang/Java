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
//	一个数组存放了很多个Operation，相当于存放了很多个Socket
	public static CopyOnWriteArrayList<Operation> cup=new CopyOnWriteArrayList<Operation>();
public static void main(String[] args) throws IOException {
	ServerSocket ss=new ServerSocket(8848);
//	这个while循环是最关键的地方！不然accept之后就一直执行下去，不会再accept了
	while(true) {
		Socket s1=ss.accept();
		System.out.println("一个客户端创建了连接");
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
//	目标名字
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
//		这下面几行内容是为私聊定制的，以@与：分割出目标私聊对象
//		int begin=data.indexOf("@");
//		int end=data.indexOf(":");
//		int f=data.indexOf("：:");
//		this.targetname=data.substring(begin+1, end-1);
//		this.name=data.substring(0,f-1);
		
		return data;
	}
	//发给一个人
	public void setout(Socket s,String data) throws IOException {
		os=s.getOutputStream();
		dos=new DataOutputStream(os);
		dos.writeUTF(data);
		dos.flush();
	}
	//发给所有人
	public void setoutall(String data) throws IOException {
//		这里有点绕，遍历cup数组，这个数组里面的每个Operation元素都有其Socket成员，对应其客户端
//		所以要做的调用当前operation的setout方法，把数据发到除了自己以外所有Operation的Socket
		for(Operation o:ChatServer.cup) {
			if(o==this) {
				continue;
			}else {
				setout(o.s, data);
			}
		}
	}
	//发给指定的人
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
