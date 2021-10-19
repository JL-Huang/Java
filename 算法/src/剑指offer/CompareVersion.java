package 剑指offer;
//如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
public class CompareVersion {
    public int test(String version1, String version2) {
    	String[] strs_1=version1.split("\\.");
    	String[] strs_2=version2.split("\\.");
    	int length_1=strs_1.length;
    	int length_2=strs_2.length;
    	for(int i=0;i<Math.max(length_1, length_2);i++) {
    		int i1=i<length_1?Integer.valueOf(strs_1[i]):0;
    		int i2=i<length_1?Integer.valueOf(strs_2[i]):0;
    		if(i1!=i2) return i1>i2?1:-1;
    	}
    	return 0;
    }
}
