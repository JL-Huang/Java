package 剑指offer;
//“student. a am I”翻转了为“I am a student.”。
public class ReverseSentence {
	public static void main(String[] args) {
		ReverseSentence reverseSentence=new ReverseSentence();
		reverseSentence.test("I AM SS");
	}
    public String test(String str) {
    	if(str==null) return null;
    	if(str.trim().equals("")) return str;
        String[] strs=str.split(" ");
        for(int i=0;i<strs.length/2;i++) {
        	String temp=strs[i];
        	strs[i]=strs[strs.length-i-1];
        	strs[strs.length-i-1]=temp;
        }
        String result="";
        for(int i=0;i<strs.length;i++) result+=(strs[i]+" ");
        return result.trim();
    }
}
