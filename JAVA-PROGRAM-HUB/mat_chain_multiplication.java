import java.util.Scanner;
class mat_chain_multiplication {
    static int MatrixChainOrder(int p[], int i, int j){
        if(i==j)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int count=MatrixChainOrder(p,i,k)+MatrixChainOrder(p,k+1,j)+p[i-1]*p[k]*p[j];
            if(count<min)
                min=count;            
        }
        return min;
    }
    @SuppressWarnings("resource")
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n=sc.nextInt();
        
        int arr[]=new int[n],i;
        System.out.print("Enter the elements of array: ");
        for(i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.print("The array: ");
        for(i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        System.out.print("Minimum number of multipliaction is: "+MatrixChainOrder(arr,1,n-1));
        sc.close();
    }
}