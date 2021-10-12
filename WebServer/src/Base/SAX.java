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
//	1.��ȡ��������
		SAXParserFactory factory=SAXParserFactory.newInstance();
//	2.�ӽ���������ý�����
		SAXParser parse=factory.newSAXParser();
//	3.��д������(������)
//	4.�����ĵ�ע�ᴦ����
		PHandler pHandler=new PHandler();
//	5.����
		//��õ�ǰ�̵߳��������,�ٻ��xml�ļ���Դ,ע���ǰ���+xml�ļ���,��/����.
		InputStream is=new FileInputStream(new File("p.xml"));
		parse.parse(is,pHandler);
//		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xmlTest/p.xml"),pHandler);
//	6.��ȡ
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
//��˳��,����ʲô���ݾ�ִ�ж�Ӧ�ķ���
class PHandler extends DefaultHandler{
	private List<Person> list;
	private Person person;
//	��ǩ,���ڽ�xml���ݹ���
	String tag;
	
	public List<Person> getList() {
		return list;
	}


	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
//		System.out.println("�����ļ�ͷ,������ʼ");
		list=new ArrayList<Person>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
//		System.out.println("��ȡ��ʼ��ǩ��"+qName);
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
//		System.out.println("����Ϊ"+content);
		if(tag!=null) {
			
			if(tag.equals("name")) {
				person.setName(content);
			}else if(tag.equals("age")) {
//			���ַ���תInteger
				person.setAge(Integer.valueOf(content));
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
//		System.out.println("��ȡ������ǩ��"+qName);
		if(qName.equals("person")) {
			list.add(person);			
		}

//		ÿ������������ǩ�Ͱ�tag�ÿ�,��ֹ�������ȡ������ǩ�������
		tag=null;
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
//		System.out.println("�����ĵ�����");
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