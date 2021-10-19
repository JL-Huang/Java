package 剑指offer;

public class Fibonacci {
    public int Fibonaccitest(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
            return Fibonaccitest(n-1)+Fibonaccitest(n-2);
    }

}
