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
//		1.������ǰ�˿�
		DatagramSocket ds=new DatagramSocket(this.currentport);
//		2.��������,��õ�ַ
//		�����ǱȽ�����ĵط����������ѭ��������һ�ζ˿ھͻ�ر�
		while(true) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		byte[] bytes=str.getBytes();
//		byte[] bytes=System.in.readAllBytes();
		DatagramPacket dp=new DatagramPacket(bytes, 0, bytes.length, this.isa);
//		3.����
		ds.send(dp);
		if(str=="bye") {
			ds.close();
		}
		}
//		4.�رն˿�
		
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
