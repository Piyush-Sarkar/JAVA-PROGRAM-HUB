import java.util.Scanner;
public class heapsort {
    Scanner sc=new Scanner(System.in);
    public void sort(int arr[]){
        int N=arr.length,i,temp;
        for(i=N/2;i>=0;i--)
            heapify(arr,N,i);
        for(i=N-1;i>0;i--){
            temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    void heapify(int arr[],int N,int i){
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<N && arr[l]>arr[largest])
            largest=l; 
        if(r<N && arr[r]>arr[largest])
            largest=r;
        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;
            heapify(arr,N,largest);
        }
    }
    static void printArray(int arr[]){
        int N=arr.length,i;
        for(i=0;i<N;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    void readArray(int arr[],int N){
        int i;
        System.out.println("Enter the elements of array: ");
        for(i=0;i<N;i++)
            arr[i]=sc.nextInt();
        System.out.print("the original array: ");
        for(i=0;i<N;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        heapsort ob=new heapsort();
        System.out.print("Enter the size of array: ");
        int N=in.nextInt();
        int arr[]=new int[N];
        ob.readArray(arr, N);
        ob.sort(arr);
        System.out.print("Sorted array: ");
        printArray(arr);
        in.close();
    }
}