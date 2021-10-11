package UDPTest; 

import java.net.InetSocketAddress;

public class UDPStudent {
public static void main(String[] args) {
	new Thread(new SendThread(5555,new InetSocketAddress("localhost", 6666))).start();
	new Thread(new ReceiveThread(7777)).start();
}
}
