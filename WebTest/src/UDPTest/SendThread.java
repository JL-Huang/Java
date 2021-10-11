package UDPTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class SendThread implements Runnable{
	private int currentport;
	private InetSocketAddress isa;
	
	public SendThread(int currentport, InetSocketAddress isa) {
		super();
		this.currentport = currentport;
		this.isa = isa;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	try {
//		1.创建当前端口
		DatagramSocket ds=new DatagramSocket(this.currentport);
//		2.创建包裹,标好地址
//		这里是比较巧妙的地方，如果不用循环，发送一次端口就会关闭
		while(true) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		byte[] bytes=str.getBytes();
//		byte[] bytes=System.in.readAllBytes();
		DatagramPacket dp=new DatagramPacket(bytes, 0, bytes.length, this.isa);
//		3.发送
		ds.send(dp);
		if(str=="bye") {
			ds.close();
		}
		}
//		4.关闭端口
		
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
