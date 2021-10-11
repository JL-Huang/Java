package UDPTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ReceiveThread implements Runnable{
	private int currentport;
	
	
	public ReceiveThread(int currentport) {
		super();
		this.currentport = currentport;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
//			1.创建当前端口
			DatagramSocket ds=new DatagramSocket(this.currentport);
//			2.创建包裹准备接收
			while(true) {
			byte[] bytes=new byte[1024];
			DatagramPacket dp=new DatagramPacket(bytes, 0, bytes.length);
//			3.接收并存入包裹
			ds.receive(dp);
//			4.解析数据
			byte[] b=dp.getData();
			String str=new String(b, 0, b.length);
			System.out.println(str);
//			5.关闭端口
			if(str=="bye") {			
				ds.close();
			}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
