import java.util.*;
public class Prime_Palindrome {
    
    //Outer class 1
    static class Palindrome{
        //Nested class 1
        class Checker{
            //Method to check if number is Palindrome
            public boolean isPalin(int num){
                int original=num,rev=0;
                while(num!=0){
                    int d=num%10;
                    rev=rev*10+d;
                    num/=10;
                }
                return (original==rev);
            }
        }
    }
    
    //Outer class 2
    static class Prime{
        //Nested class 2
        class Checker{
            //Method to check if number is Prime
            public boolean isPrime(int n){
                int i,count=0;
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

    public static void main(String args[]){//main method
        Scanner sc=new Scanner(System.in);
        int choice;
        boolean exit=false;
        do{
            System.out.println("---MENU---");
            System.out.println("1. Palindrome Checker");
            System.out.println("2. Prime Checker");
            System.out.println("3. Prime_Palindrome Checker");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            System.out.println();
        
            switch(choice){//Implementing switch-case
                case 1: do{ 
                            System.out.print("Enter a number: ");
                            int num=sc.nextInt();
                            Palindrome.Checker ch=new Palindrome().new Checker();
                            if(ch.isPalin(num))
                                System.out.println(num + " is a Palindrome number.");
                            else
                                System.out.println(num + " is not a Palindrome number.");
                            System.out.println("Do you want to continue? (y/n): ");
                        }while(sc.next().charAt(0)=='y'); // while(choice.equalsIgnoreCase("y"));
                        break;
                case 2: do{
                            System.out.print("Enter a number: ");
                            int num1=sc.nextInt();
                            Prime.Checker ch1=new Prime().new Checker();
                            if(ch1.isPrime(num1))
                                System.out.println(num1 + " is a Prime number.");
                            else
                                System.out.println(num1 + " is not a Prime number.");
                            System.out.println("Do you want to continue? (y/n): ");
                        }while(sc.next().charAt(0)=='y'); // while(choice.equalsIgnoreCase("y"));
                        break;
                case 3: do{
                            System.out.print("Enter a number: ");
                            int n=sc.nextInt();
                            Palindrome.Checker a=new Palindrome().new Checker();
                            Prime.Checker b=new Prime().new Checker();
                            if(a.isPalin(n) && b.isPrime(n))
                                System.out.println(n + " is a Palindrome as well as Prime.");
                            else
                                System.out.println(n + " is neither a Palindrome nor a Prime.");
                            System.out.println("Do you want to continue? (y/n): ");
                        }while(sc.next().charAt(0)=='y');
                        break;
                case 4: System.out.println("Exiting...Thank you for your responses!!");
                        exit=true;
                        break;
                default:System.out.println("Invalid choice!!Press anything from 1-4"); 
            }
        }while(!exit);
        sc.close();
    }
}