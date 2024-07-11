package IO;
//字节输入流是直接对内存操作，有GC进行内存管理，不需要close
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteIO {
public static void main(String[] args) {
	System.out.println(ByteI());
//	下面的代码会输出地址，原因是返回的是写好的字节数组，还没有经过译码
	System.out.println(ByteO());
//	String构造方法的偏移量与长度，针对的都是字节数组而不是字符串
	System.out.println(new String(ByteO(),0,ByteO().length-4));
}
public static StringBuffer ByteI() {
	String str="caahszxchz";
	StringBuffer sb=new StringBuffer();
	byte[] bytes1=str.getBytes();	//这是要读取的容器
	ByteArrayInputStream is=new ByteArrayInputStream(bytes1);	//字节输入流以及其构造方法
	try {
		int i=-1;
		byte[] temp=new byte[2];
		while((i=is.read(temp))!=-1) {
			sb.append(new String(temp, 0,i));
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sb;
}
public static byte[] ByteO() {
//	字节输出流写入字节源，长度不好把握，所以由系统自行产生源
//	这里不能用OutputStream，因为ByteArrayOutputStream()有新增方法不能实现多态
	ByteArrayOutputStream os=new ByteArrayOutputStream();
	String str="ahauhaschacuh";
	try {
		os.write(str.getBytes());
		os.flush();			//任何输出流写完后都要flush，把输出流缓冲区的数据全部刷新出去

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	将字节输出流写好的数组输出使用的是字节输出流的toByteArray()方法
	return os.toByteArray();	
}
}
