package ��ָoffer;

import java.util.HashMap;

//��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��,
//���û���򷵻� -1����Ҫ���ִ�Сд������0��ʼ������
public class FirstNotRepeatingChar {
    public int test(String str) {
//    	˼·����map������ĸΪ�������ִ���Ϊֵ�����α�����һ�δ�ֵ��һ�β�ֵ
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<str.length();i++) {
//        	�����е㼼�ɣ��ȳ���ȥ�飬�鲻���͸�1����õ��ͼ�һ
        	if(map.get(str.charAt(i))!=null) 
        		map.put(str.charAt(i), map.get(str.charAt(i))+1);
        	else map.put(str.charAt(i), 1);
        }
        for(int i=0;i<str.length();i++) {
        	if(map.get(str.charAt(i))==1) return i;
        }
        return -1;
    }
}
