package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX {
public static void main(String[] args) {
	try {
//	1.获取解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
//	2.从解析工厂获得解析器
		SAXParser parse=factory.newSAXParser();
//	3.编写处理器(在下面)
//	4.加载文档注册处理器
		PHandler pHandler=new PHandler();
//	5.解析
		//获得当前线程的类加载器,再获得xml文件资源,注意是包名+xml文件名,用/不用.
		InputStream is=new FileInputStream(new File("p.xml"));
		parse.parse(is,pHandler);
//		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xmlTest/p.xml"),pHandler);
//	6.获取
		List<Person> list=pHandler.getList();
		for(Person temp:list) {
			System.out.println(temp.getName()+temp.getAge());
		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
//流顺序,遇到什么内容就执行对应的方法
class PHandler extends DefaultHandler{
	private List<Person> list;
	private Person person;
//	标签,用于将xml内容归类
	String tag;
	
	public List<Person> getList() {
		return list;
	}


	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
//		System.out.println("检索文件头,解析开始");
		list=new ArrayList<Person>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
//		System.out.println("获取开始标签名"+qName);
		if(qName!=null) {
			tag=qName;
			
		}
		if(qName.equals("person")) {
			person=new Person();
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		String content=new String(ch,start,length);
//		System.out.println("内容为"+content);
		if(tag!=null) {
			
			if(tag.equals("name")) {
				person.setName(content);
			}else if(tag.equals("age")) {
//			将字符串转Integer
				person.setAge(Integer.valueOf(content));
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		System.out.println("获取结束标签名"+qName);
		if(qName.equals("person")) {
			list.add(person);			
		}

//		每次遇到结束标签就把tag置空,防止程序误读取结束标签后的内容
		tag=null;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
//		System.out.println("解析文档结束");
	}
	
}
class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}