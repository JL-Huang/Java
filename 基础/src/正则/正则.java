package 正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则 {
    public static void main(String[] args) {
        // 正则表达式
        String reg = "expression=.*";
        // 需要匹配的字符串
        String str = "expression=666";
        // 预编译
        Pattern patten = Pattern.compile(reg);
        // 进行匹配
        Matcher matcher = patten.matcher(str);
        String a=new String();
        /**
         * matcher.find()为true表示匹配到，如果匹配到多个下一次循环偏移到下一个匹配
         * 每一次匹配可以理解为一组，从0开始
         */
        while (matcher.find()) {
            // 疯狂操作
            // 利用start和end我们可以确定匹配到的字符串的位置
            // 当前匹配到的字符串的开始在原字符串的索引位置
            matcher.start();
            // 当前匹配到的字符串的结尾在原字符串的索引位置
            matcher.end();
            // 当前匹配到的字符串
            matcher.group();
            // 替换第一次匹配的数据
            a=matcher.replaceFirst("sfdf");
            // 替换所有匹配的数据
            matcher.replaceAll("");
        }
        System.out.println(a);
        String aaa="ddfs/ff";
        System.out.println(aaa.substring(0,aaa.lastIndexOf("/")));
    }
}

