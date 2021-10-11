package Exception相关;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//							Throwable
//		Error									Exception
//	UncheckedException			checkedException		RutimeException
//															UncheckedException
//RutimeException:空指针异常，被零除，数组下标越界等，运行时报错等
//JVM没有固定的处理方法，所以需要自己添加逻辑判断，如指针为空则怎样，除数为0则怎样等等
//checkedException，已经被编译器检查到的异常，编译就已经出错
public class 异常 {
	public static void main(String[] args) {
		
		
	Animal a=new Dog();
//	判断a是否是Cat类
	if(a instanceof Cat) {
		Cat c=(Cat)a;
	}
	TryTest.hhh();
	}
}
//try语句有可以有多条代码，执行过程中任意一条出错，都会抛出一个异常对象给相应的catch语句
//	一个try语句至少要带一个catch语句块或一个finally语句块
//	没有异常或异常处理完后，都会跳到finally语句，不再执行try中的语句
//	catch有toString()显示异常类名,getMessage()显示异常原因,printStackTrace()跟踪异常事件发生时堆栈内容等常用方法
//	异常类有继承关系时，子类放前面
//	finally常用于执行有没有异常都要执行的语句，如关闭文件流，释放数据库连接]
	
//	FileReader是InputStream的子类
	class TryTest{
//		注意一定要把该方法修饰为静态，否则main方法无法调用
		 static public void hhh() {
		FileReader reader=null;
		File f1=new File("f.txt");
		try {
		reader=new FileReader(f1);
		while(reader.read()!=-1) {
//			 这里每次都是这样，从第二个开始隔位读，迷
		char c1=(char)reader.read();
		System.out.println(c1);
		}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("找不到文件");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("读取错误");
		}
				finally {
			System.out.println("释放资源");
			try {
				if(reader!=null)
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
	
	
//	throws是直接把异常抛出，谁调用谁处理
//	throws在方法之后声明，抛出的就是catch括号内的内容，如throws IOException;
//	要注意的是，一个throws了以后，调用该方法的方法必须也throws或者trycatch
//	可以一层层throws，最后main方法把throws抛出给JRE
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}