package ��ָoffer;
//��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
//���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
//���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"
//�����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���

import java.util.ArrayList;
import java.util.HashMap;

public class FirstAppearingOnce {
	HashMap<Character, Integer>map=new HashMap<Character, Integer>();
	ArrayList<Character>list=new ArrayList<Character>();
    public void Insert(char ch)
    {
    	if(map.get(ch)==null) map.put(ch, 1);
    	else map.put(ch, -1);
    	list.add(ch);
    }
  //return the first appearence once char in current stringstream
    public char test()
    {
    int i=0;
    while(true) {
    	if(i>list.size()-1) return '#';
    	if(map.get(list.get(i))==1) return list.get(i);
    	i++;	
    }
    
    }
}
