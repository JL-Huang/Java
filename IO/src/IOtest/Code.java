package IOtest;

import java.io.UnsupportedEncodingException;

//UTF-8:�䳤�ȣ�1-3���ֽڣ�Ӣ��Ĭ�ϱ��뷽ʽ
//UTF-16LE:�����ȣ�2���ֽ�
//GBK�������ȣ�2���ֽڣ�����Ĭ�ϱ��뷽ʽ������Ҳ����ĸ
public class Code {

public static void main(String[] args) throws UnsupportedEncodingException {
	String str="��Ὠ��a";
	String str2="adfaasdfsdfa";
	byte[] bytes1=str.getBytes("GBK");
	System.out.println(bytes1.length);
	byte[] bytes2=str.getBytes("UTF-8");
	System.out.println(bytes2.length);
	byte[] bytes3=str.getBytes();//������붼Ĭ�Ϻ���GBK��Ӣ��UTF-8
	System.out.println(bytes3.length);
	String dstr=new String(bytes2, "GBK");//�����ˣ���Ϊbytes2��UTF-8���룬������������GBK�ж�Ӧ��ĺ���
	System.out.println(dstr);
	String ddstr=new String(bytes1, "UTF-8");//�����ˣ���Ϊbytes1��GBK���룬������������UTF-8��û�ж�Ӧ
	System.out.println(ddstr);
}
}
