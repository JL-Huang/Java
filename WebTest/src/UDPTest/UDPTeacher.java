package UDPTest;

import java.net.InetSocketAddress;

public class UDPTeacher {
	public static void main(String[] args) {
		new Thread(new SendThread(8888, new InetSocketAddress("localhost", 7777))).start();
		new Thread(new ReceiveThread(6666)).start();
	}
}
