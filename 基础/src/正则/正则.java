package ����;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ���� {
    public static void main(String[] args) {
        // ������ʽ
        String reg = "expression=.*";
        // ��Ҫƥ����ַ���
        String str = "expression=666";
        // Ԥ����
        Pattern patten = Pattern.compile(reg);
        // ����ƥ��
        Matcher matcher = patten.matcher(str);
        String a=new String();
        /**
         * matcher.find()Ϊtrue��ʾƥ�䵽�����ƥ�䵽�����һ��ѭ��ƫ�Ƶ���һ��ƥ��
         * ÿһ��ƥ��������Ϊһ�飬��0��ʼ
         */
        while (matcher.find()) {
            // ������
            // ����start��end���ǿ���ȷ��ƥ�䵽���ַ�����λ��
            // ��ǰƥ�䵽���ַ����Ŀ�ʼ��ԭ�ַ���������λ��
            matcher.start();
            // ��ǰƥ�䵽���ַ����Ľ�β��ԭ�ַ���������λ��
            matcher.end();
            // ��ǰƥ�䵽���ַ���
            matcher.group();
            // �滻��һ��ƥ�������
            a=matcher.replaceFirst("sfdf");
            // �滻����ƥ�������
            matcher.replaceAll("");
        }
        System.out.println(a);
        String aaa="ddfs/ff";
        System.out.println(aaa.substring(0,aaa.lastIndexOf("/")));
    }
}

