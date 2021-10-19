package 华为;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class p10{
    public static void main(String[] args) throws InterruptedException{
    	String str1=new String("h2h");
    	String str2=new String("hhh");
//    		System.out.println(str2.split("h").length);
//    	Set<Character> set=new HashSet<Character>();
    	Integer[] hh=new Integer[10];
    	TreeSet<Integer> set=new TreeSet();
    	set.add(2);
    	set.add(4);
    	Integer[] jj=new Integer[set.size()];
    	set.toArray(jj);
    	Arrays.sort(jj);
//    	System.out.println(jj[1]);
//    	System.out.println(hh.length);
    	hh[1]=null;
//    	System.out.println(hh[1]);
    	str1.equals(str2);
//    	Character c='s';
//    	c.equals(c);
    	Integer i1=128;
    	Integer i2=128;
//    	System.out.println(i1==i2);
//    	System.out.println(i1.equals(i2));
    	char[] c=new char[10];
    	str1.getChars(0, 2, c, 2);
    	Stack<Character> stack=new Stack();
    	stack.isEmpty();
    	ConcurrentHashMap<Integer, Integer> h=new ConcurrentHashMap<Integer, Integer>();
    	h.put(i1, i2);
//    	stack.is
//    	stack.peek();
//    	System.out.println(c);
//    	System.out.println(str1==str2);
//    	System.out.println(str1.hashCode());
//    	System.out.println(str2.hashCode());
//    	System.out.println(str1.equals(str2));
    	ConcurrentHashMap<Integer,String>map=new ConcurrentHashMap<Integer, String>();
    	HashMap<Integer,String>map1=new HashMap<Integer, String>();
    	map.put(1, "one");
    	map1.put(2, "two");
    	StringBuilder sb=new StringBuilder();
//    	sb.deleteCharAt(1);
    	int[] is=new int[0];
    	Queue<Integer>r;
    	int[] arr=new int[] {4,8,1,9};
    	int a=Arrays.stream(arr).max().getAsInt();
//    	System.out.println(a);
    	Deque<Integer>e=new LinkedList<Integer>();
    	e.offerLast(1);
    	LinkedList<String> list=new LinkedList<String>();
    	list.offer("abv");
    	list.offer("ab");
//    	list.offer(null);
//    	System.out.println(list.toString());
    	Integer dd=100;
    	list.sort(null);
//    	System.out.println(list);
//    	System.out.println(Integer.toBinaryString(dd));
    	short ss=1;
    	ss+=1;
//    	System.out.println(ss);
    	SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
    	long l1=System.currentTimeMillis();
//    	Thread.sleep(3000);
    	long l2=System.currentTimeMillis();
    	formatter.format(new Date((l2-l1-3600*1000*8)));
//    	System.out.println(formatter.format(new Date((l2-l1-3600*1000*8))));
    	ArrayList<String> lls=new ArrayList();
    	lls.add(str1);
    	lls.remove(0);
    	HashMap<Integer, Integer>mapp=new HashMap<Integer, Integer>();
    	mapp.put(2,1);
    	mapp.put(18,31);
    	mapp.remove(1,31);
    	mapp.replace(2, 12);
System.out.println(mapp.containsValue(1));
    	System.out.println(mapp);
//    	System.out.println(judge("121"));
    	int[] arrr=new int[]{1,'a',3};
    	System.out.println(Arrays.stream(arrr).min().getAsInt());
    	Collections.reverse(list);
//    	System.out.println(list);
   
    	System.out.println(new Date());
    }
    public static boolean judge(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
