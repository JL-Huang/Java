package 剑指offer;
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
//例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
//但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
public class isNumeric {
//	不懂正则，写出来的代码就很丑，太烂了
	public static void main(String[] args) {
		isNumeric isNumericc=new isNumeric();
		char[] chars=new String("123.45e+6").toCharArray();
		System.out.println(isNumericc.test(chars));
	}
    public boolean test(char[] str) {
    	String str1=new String(str);
    	String[] strs1=str1.split("E");
    	if(strs1.length==1) strs1=str1.split("e");
        switch (strs1.length){
        case 1:{
        	if(str1.contains("E")||str1.contains("e")) return false;
        	return part1(strs1[0]);
        }
        case 2:{
        	if(!part1(strs1[0])) return false;
        	if(!part2(strs1[1])) return false;
        	return true;
        }
        default:return false;
        }
    }
//    判断一个字符串是否是整数或小数
    public boolean part1(String str) {
//    	System.out.println(str);
    	String[] strs2=str.split("\\.");
//    	System.out.println(strs2.length);
    	if(strs2.length==1) {
    		for(int i=strs2[0].length()-1;i>=1;i--) {
//    			System.out.println(strs2[0].charAt(i));
    			if(strs2[0].charAt(i)<48||strs2[0].charAt(i)>57) return false;
    		}
//			System.out.println(strs2[0].charAt(0));
    		if((strs2[0].charAt(0)<48||strs2[0].charAt(0)>57)&&(strs2[0].charAt(0)!='+'&&strs2[0].charAt(0)!='-')) return false;
    	}
    	if(strs2.length==2) {
//    		System.out.println("kkk");
    		for(int i=strs2[0].length()-1;i>=1;i--) {
    			if(strs2[0].charAt(i)<48||strs2[0].charAt(i)>57) return false;
    		}
    		if((strs2[0].charAt(0)<48||strs2[0].charAt(0)>57)&&(strs2[0].charAt(0)!='+'&&strs2[0].charAt(0)!='-')) return false;
    		for(int i=strs2[1].length()-1;i>=0;i--) {
    			if(strs2[1].charAt(i)<48||strs2[1].charAt(i)>57) return false;
    		}
    	}
    	if(strs2.length>2) return false;
    	return true;
    }
//    判断一个字符串是否是带符号整数
    public boolean part2(String str) {
    	String[] strs2=str.split("\\.");
    	if(strs2.length==1) {
    		for(int i=strs2[0].length()-1;i>=1;i--) {
    			if(strs2[0].charAt(i)<48||strs2[0].charAt(i)>57) return false;
    		}
    		if((strs2[0].charAt(0)<48||strs2[0].charAt(0)>57)&&(strs2[0].charAt(0)!='+'&&strs2[0].charAt(0)!='-')) return false;
    	}
    	if(strs2.length>1) return false;
    	return true;
    }
}
