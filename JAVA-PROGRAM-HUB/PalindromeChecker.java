import java.util.*;
public class PalindromeChecker{
    //Outer class
    static class Palindrome{
        //Nested class
        class Checker{
            //Method to check if a number is Palindrome
            public boolean isPalin(int num){
                int original=num,rev=0;
                while(num!=0)
                {
                    int d=num%10;
                    rev=rev*10+d;
                    num/=10;
                }
                return (original==rev);
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");//user input
        int num=sc.nextInt();
        
        //Create an instance of the nested class
        Palindrome.Checker checker=new Palindrome().new Checker();

        //Check if the number is a palindrome
        if(checker.isPalin(num))
            System.out.println(num+" is a Palindrome.");
        else
            System.out.println(num+" is not a Palindrome.");    
        sc.close();
    }
}