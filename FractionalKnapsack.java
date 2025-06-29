import java.util.*;
public class FractionalKnapsack {
    static float p[]=new float[100];
    static float w[]=new float[100];
    static int n;
    static float a[]=new float[100];
    static void swap(float arr[],int x,int y){
        int temp=(int) arr[x];
        arr[x]=a[y];
        arr[y]=temp;
    }
    static float[] fractionalKnapsack(int W,int n){
        float x[]=new float[100];
        int load=0,i=1;
        float r;
        for(i=1;i<=n;i++)
            x[i]=0.0f;
        load=0;
        i=1;
        while((load < W) && (i <= n)){
            if(w[i] + load <= W){
                load=(int)(load+w[i]);
                x[i]=1.0f;
            }
            else{
                r=W-load;
                load=(int) (load + r / (float) w[i]);
                x[i]=r / (float) w[i];
            }
            i++;
        }
        return x;
    }
    @SuppressWarnings("resource")
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        float ratio[];
        int sum=0,i,j,W;
        System.out.println("Enter the number of items:");
        n=in.nextInt();
        System.out.println("Enter the total weight of the knapsack:");
        W=in.nextInt();
        for(i=1;i<=n;i++){
            System.out.println("Enter the profit and weight of item "+ i +":");
            p[i]=in.nextInt();
            w[i]=in.nextInt();
            a[i]=(float) p[i]/w[i];
        }
        for(i=1;i<=n;i++){
            for(j=i+1;j<=n;j++){
                if(a[i]<a[j]){
                    swap(a,j,i);
                    swap(p,j,i);
                    swap(w,j,i);
                }
            }
        }
        ratio=fractionalKnapsack(W,n);
        for(i=1;i<=n;i++)
            sum+= (p[i]*ratio[i]);
        System.out.println("The maximum profit is: "+sum);        
        in.close();
    }
}