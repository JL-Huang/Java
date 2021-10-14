package 华为;

import java.util.Scanner;

//计算字符串最后一个单词的长度，单词以空格隔开。


//public class p1 {
//public static void main(String[] args) {
////	system.in,回车输入结束
//	Scanner sc=new Scanner(System.in);
////	判断是否还有输入，遇到空格或换行返回false
//	while(sc.hasNext()) {
//		String str=sc.next();
//		System.out.println(str);
//	}
////	判断是否还有输入，遇到空格或输入完了返回false
////	可以看到，sc内部有一个游标，每一次执行next或nextline游标移动，并将移动过的路径返回字符串
//	while(sc.hasNextLine()) {
//		String strr=sc.nextLine();
//		System.out.println(strr);
//	}
//}
//}

public class p1{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String s="";
    while(sc.hasNextLine()){
        s=sc.nextLine();
        System.out.println(s.length()-1-s.lastIndexOf(" "));
    }
}
}