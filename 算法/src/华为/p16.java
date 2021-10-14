package »ªÎª;

import java.util.HashMap;

class p16 {
	public static void main(String[] args) {
		char[] chars={'a','a','b'};
		System.out.println(""+compress(chars));
	}
    public static int compress(char[] chars) {
        int lengthbefore=chars.length;
        HashMap<Character,Integer> map=new HashMap();
        for(int i=0;i<chars.length;i++){
            if(!map.containsKey(chars[i]))
            map.put(chars[i],1);
            if(map.containsKey(chars[i])){
                Integer j=map.get(chars[i]);
                map.put(chars[i],++j);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<chars.length;){
            sb.append(String.valueOf(chars[i]));
            String str=""+((map.get(chars[i])-1));
            sb.append(str);
            i=i+Integer.parseInt(str);
        }
        int lengthafter=sb.toString().toCharArray().length;
        return lengthbefore>=lengthafter?lengthafter:lengthbefore;
    }
}
