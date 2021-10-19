package IOtest;
//输入流：把文件上的内容输入到内存，输入流构造方法的参数就是的文件
//输入流的read()方法，是指读输入流的内容，相当于间接读文件的内容
//输出流：把内存输出到一个文件，输出流的写，是把输出流（内存）的内容写到文件中
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class StandardIS {
public static void main(String[] args) {
	File file=new File("abc.txt");
//	InputStream是一个抽象类，必须重写read()方法，对于文件，其实现类为FileInputStream
//要注意的是，如果想在try以外调用该输入流，trycatch前一定要先声明is，再在try里实例化
		try {
//			文件输入流必然要抛出异常，是找不到文件异常
			InputStream is=new FileInputStream(file);
//			读到最后一个字节，再读下一个会读到-1
//		读API文档才发现一个事情，像下面这样子是不不能做到读取整个输入流的。错误之处在于受之前影响，把输入流当成了
//	容器来处理，这是不正确的。每一次执行read()方法，都会将一个（或多个，看read()方法的参数）存入数组b，只要执行了
//	read()方法，就会从b获取当前读到的位置，然后读下一个，再覆盖b的值，所以read()是有记忆的。但是容器不同，容器是
//	读当前内容，存入a，若a不为-1，将当前内容存入b，输出b，两者是完全不同的
//			while(is.read()!=-1) {
//			read()方法返回值是int，要强转才能变为char
//				System.out.println(is.read());
//			}
//			read()方法返回值是int，要强转才能变为char
//			read()方法也一定要抛出异常，是IO的总异常
			System.out.println((char)is.read());
//			System.out.println(is.read(new byte[4]));直接这样返回的是缓冲容器长度,必须要把容器内容转换成相应类型
			byte[] bytes=new byte[3];	//创建一个新容器,1024对于1kb
//			下面这种做法就可以做到while循环遍历，因为有中间容器bytes
			int j;
			while((j=is.read(bytes))!=-1) {			//读取容器长度的内容，然后存入容器里
//				注意这个偏移量，是指写入bytes时从bytes哪个地方开始，不是目的地的偏移
				String str=new String(bytes,0,j);	//把容器里的内容转化成字符串,由抽象到具体，译码操作
				System.out.print(str);
			}
//	最后一定要关闭输入流，关闭时也要抛出异常，抛出的异常是checkedException
//	但是这里还可能出现RutimeException，要手动操作
			if(is!=null) {
			is.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	
}
}
