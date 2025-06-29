import java.util.Scanner;
public class basic_pattern{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,n;
        System.out.print("Enter the no. of rows: ");
        n=sc.nextInt();
        System.out.print("The pattern:\n");
        for(i=0;i<n;i++){
            for(j=0;j<n-i;j++)
                System.out.print(" ");
            for(j=0;j<i;j++)
                System.out.print("*"+" ");
            System.out.println();
        }
    }
}