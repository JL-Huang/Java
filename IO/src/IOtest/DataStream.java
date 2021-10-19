 package IOtest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

//DataInputStream,DataOutputStream
//构造方法参数为一个字节流,数据流独有的读写方法可以将不同类型的数据分别存储
//但是仅支持八种数据类型和字符串
//插播一个对象流，对象流可以分别存储任何类的数据，但前提是该类实现了java.io.Serializable接口
//对象流写有一个dos.writeObject方法，写时没问题，但是读取时要强转
//判断是不是某种类型，用instanceof方法，返回布尔类型
public class DataStream {
public static void main(String[] args) {
	// 先写入一个字节输出流

	try {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
//		任何流在实例化时，就指定了其操作目标对象
		DataOutputStream dos=new DataOutputStream(baos);
		dos.writeUTF("哈哈哈");
		dos.writeInt(7);
		dos.write(6);
		dos.flush();
		byte[] bytes=baos.toByteArray();
		ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
		DataInputStream dis=new DataInputStream(bais);
//		注意的是，存的顺序要和取的顺序一模一样，否则会报错
		String s=dis.readUTF();
		int i=dis.readInt();
		System.out.println(i);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
