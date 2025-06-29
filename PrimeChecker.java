import java.util.Scanner;
public class PrimeChecker {
    static class Prime{
        class Checker{
            int count=0,i;
            boolean isPrime(int n){
                for(i=2;i<=Math.sqrt(n);i++){
                    if(n%i==0)
                        count=1;
                }
                if(count==1)
                    return false;
                else
                    return true; 
            }
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        Prime.Checker ch=new Prime().new Checker();
        if(ch.isPrime(num))
            System.out.print(num+" is a prime");
        else
            System.out.println(num+" is a composite");
        sc.close();
    }
}
