import java.util.*;
public class Calculator {
    public double add(double a,double b){
        return a+b;
    }
    public double subtract(double a,double b){
        return a-b;
    }
    public double multiply(double a, double b) {
        return a * b;
    }
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
    public static void main(String[] args) {
        double a,b;
        Calculator c = new Calculator();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter two numbers " );
        a=in.nextDouble();
        b=in.nextDouble();
        while(true)
        {System.out.println("Press + for add " );
        System.out.println("Press - for sub " );
        System.out.println("Press * for mul " );
        System.out.println("Press / for div " );
        System.out.println("Press ! for exit " );
        char ch=in.next().charAt(0); ;
            switch (ch) {
                case '+':
                System.out.println("Addition =: " + c.add(a,b));
                    break;
                    case '-':
                    System.out.println("Subtraction =: " + c.subtract(a, b));
                    break;
                    case '*':
                    System.out.println("Multiplication =: " + c.multiply(a, b));
                    break;
                    case '/':
                    System.out.println("Division =: " + c.divide(a, b));
                    break;
                    case '!':
                    System.exit(0);            
                default:
                System.out.println("Wrong choice " );
            }
            in.close();
        }  
    }
}
