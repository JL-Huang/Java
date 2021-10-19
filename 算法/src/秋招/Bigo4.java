package 秋招;


public class Bigo4 {
	public static void main(String[] args) {
		String str_1="11.12.11";
		String str_2="11.12.12";
		System.out.println(compare_version(str_1, str_2));
	}
	public static boolean compare_version(String str_1,String str_2) {
		String[] str_1_spilt=str_1.split(".");
		String[] str_2_spilt=str_2.split(".");
		if(str_1_spilt.length!=str_2_spilt.length) {
			return false;
		}
		int length=str_1_spilt.length;
		for(int i=0;i<length;i++) {
			
			for(int j=0;j<str_1_spilt[i].length();j++) {
				if(str_1_spilt[i].toCharArray()[j]>'9'||str_1_spilt[i].toCharArray()[j]<'0') {
					return false;
				}
			}
			for(int j=0;j<str_2_spilt[i].length();j++) {
				if(str_2_spilt[i].toCharArray()[j]>'9'||str_2_spilt[i].toCharArray()[j]<'0') {
					return false;
				}
			}
			int version_1=Integer.parseInt(str_1_spilt[i]);
			int version_2=Integer.parseInt(str_2_spilt[i]);
			System.out.println(version_1);
			System.out.println(version_2);
			if(version_1!=version_2) return false;
		}
		return true;
	}
}
