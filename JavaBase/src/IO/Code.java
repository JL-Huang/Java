package IO;

import java.io.UnsupportedEncodingException;

//UTF-8:变长度，1-3个字节，英文默认编码方式
//UTF-16LE:定长度，2个字节
//GBK，定长度，2个字节，汉字默认编码方式，里面也有字母
public class Code {

public static void main(String[] args) throws UnsupportedEncodingException {
	String str="社会建设a";
	String str2="adfaasdfsdfa";
	byte[] bytes1=str.getBytes("GBK");
	System.out.println(bytes1.length);
	byte[] bytes2=str.getBytes("UTF-8");
	System.out.println(bytes2.length);
	byte[] bytes3=str.getBytes();//编码解码都默认汉字GBK，英文UTF-8
	System.out.println(bytes3.length);
	String dstr=new String(bytes2, "GBK");//乱码了，因为bytes2是UTF-8编码，编码后的码字在GBK中对应别的汉字
	System.out.println(dstr);
	String ddstr=new String(bytes1, "UTF-8");//乱码了，因为bytes1是GBK编码，编码后的码字在UTF-8中没有对应
	System.out.println(ddstr);
}
}
