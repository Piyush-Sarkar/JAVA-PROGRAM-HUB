import java.util.*;
public class Knapsack {
    public static int findMax(int n1, int n2) {
        if(n1>n2) {
           return n1;
        } else {
           return n2;
        }
     }
    static int knapsack(int W,int wt[],int val[],int n){
        int i,w;
        int knap[][]=new int[n+1][W+1];
        for(i=0;i<=n;i++){
            for(w=0;w<=W;w++){
                if(i==0 || w==0)
                    knap[i][w]=0;
                else if(wt[i-1]<=w)
                    knap[i][w]=findMax(val[i-1]+knap[i-1][w-wt[i-1]],knap[i-1][w]);
                else
                    knap[i][w]=knap[i-1][w];
            }
        }
        return knap[n][W];
    }
    @SuppressWarnings("resource")
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];
        int i;
        System.out.print("Enter the value of items: ");
        for(i=0;i<n;i++)
            val[i]=sc.nextInt();
        System.out.print("Enter the weights of items: ");
        for(i=0;i<n;i++)
            wt[i]=sc.nextInt();
        System.out.print("Enter the capacity of the knapsack: ");
        int W=sc.nextInt();
        System.out.print("The maximum value that can be put in a knapsack of capacity "+W+" is: "+knapsack(W,wt,val,n));        
        sc.close();
    }
}