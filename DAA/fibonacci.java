import java.util.Scanner;

public class fibonacci {
    public static int fibonaci(int n) {
        if (n<=1) return n;

        int a=0;
        int b=1;
        for(int i=2;i<=n;i++){
            int temp = a+b;
            a=b;
            b=temp;
        }
        return b;
    }

    public static int fibonaccirec(int n) {
        if (n <= 1) return n;
        return fibonaccirec(n - 1) + fibonaccirec(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many number you want : ");
        int n = sc.nextInt(); 

        System.out.println("Fibonacci of " + n + " (Iterative): " + fibonaci(n));
        System.out.println("Fibonacci of " + n + " (Recursive): " + fibonaccirec(n));
        sc.close();
    }
}
