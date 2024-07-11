//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//        (s 里只包含数字、+、-)
//        15+55-42+9-2

import java.util.Stack;

public class TTT {
    public static void main(String[] args) {
        int result = new TTT().caculerPlus("15+55-42+9-2");
        System.out.println(result);
    }

//    5+15*5/5*15-5
//    +*/*-
//    5 15 5 5 15 5
//    + -
//    5 225 5
private int caculer(String realString) {
    Stack<Character> operateStack=new Stack<>();
    Stack<Integer> numStack=new Stack<>();
    StringBuilder numString=new StringBuilder("");
    int result=0;
    for (int i = 0; i < realString.length(); i++) {
        if(realString.charAt(i)== '+' ||realString.charAt(i)=='-'||realString.charAt(i)=='*'||realString.charAt(i)=='/'){
            operateStack.push(realString.charAt(i));
            int num=Integer.valueOf(realString);
            char oper=operateStack.pop();
            switch (oper){
                case '*':{
                    int temp=numStack.pop()*numStack.pop();
                    result+=temp;
                    numStack.push(temp);
                    operateStack.pop();
                }
                case '/':{
                    int pop1=numStack.pop();
                    int pop2=numStack.pop();
                    int temp=pop2/pop1;
                    result+=temp;
                    numStack.push(temp);
                    operateStack.pop();
                }
            }
            numStack.push(num);
            numString=new StringBuilder("");
        }else {
            numString.append(realString.charAt(i));
        }
    }
    int beforeNum=0;
    if(numStack.peek()!=null){
        beforeNum=numStack.pop();
        while (numStack.peek()!=null){
            int oper=operateStack.pop();
            int num=numStack.pop();
            if(oper=='+'){
                beforeNum+=num;
            }else if(oper=='-'){
                beforeNum-=num;
            }
        }
    }
    return beforeNum;
}
    private int caculerPlus(String s) {
        String[] plusString = s.split("\\+");
        int[] plusInt = new int[plusString.length];
        for (int i = 0; i < plusString.length; i++) {
            plusInt[i] = caculerSub(plusString[i]);
        }
        int result = 0;
        for (int i = 0; i < plusString.length; i++) {
            result += plusInt[i];
        }
        return result;
    }

    private int caculerSub(String subString) {
        String[] sub = subString.split("-");
        int result = 0;
        if (sub.length == 0) {
            return result;
        }
        if (sub.length == 1) {
            return Integer.valueOf(sub[0]);
        }
        result += Integer.valueOf(sub[0]);
        for (int i = 1; i < sub.length; i++) {
            result -= Integer.valueOf(sub[i]);
        }
        return result;
    }
}
