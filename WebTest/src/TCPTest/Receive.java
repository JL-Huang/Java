package TCPTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Receive implements Runnable{
	Socket s;
	InputStream is;
	DataInputStream dis;
	
	public Receive(Socket s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			boolean isrunning=true;
			while(isrunning) {
				is=s.getInputStream();
				dis=new DataInputStream(is);
				System.out.println(dis.readUTF());
				
			}
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
