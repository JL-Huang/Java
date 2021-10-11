package UDPbao;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receivetest {
	public static void main(String[] arg) throws Exception {
		System.out.println("接收");
		//第一步，新建一个DatagramSocket，指定本地主机的一个端口作为接收端端口
		DatagramSocket ds=new DatagramSocket(8888); 
		//第二步，新建一个容器，用来存放接收的数据,注意构造时指定容量，UDP最大是64K
		byte[] container=new byte[1024*32];
		//第三步，新建一个包裹，用DatagramPacket方法将容器打包进包裹，可以只指定两个参数，第一个是容器，一个是长度
		//UDP的简单之处在于，接收端不需要指定发送端的地址及端口
		DatagramPacket dp=new DatagramPacket(container,container.length);
		//第四步，DataSocket阻塞式接收包裹
		ds.receive(dp);
		//第五步，用getData命令打开包裹并再用一个容器装起来
		byte[] shuju=dp.getData();
		//第六步，对包裹里的信息进行处理
		System.out.println(new String(shuju));
		//第七步，释放DataSocket中的资源
		ds.close();
	}

}
