import java.util.*;
public class NQueens {
    static final int MAX=20;
    static int board[][] = new int[MAX][MAX];
    static void printSolution(int N){
        int i,j;
        for(i=0;i<N;i++) { 
            for(j=0;j<N;j++)
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            System.out.println();
        }
    }
    // Function to check if a queen can be placed on board[row][col]
    static boolean isSafe(int row,int col,int N) {
        int i,j;
        for(i=0;i<col;i++)
            if(board[row][i]==1)
                return false;
        for(i=row,j=col;i>=0 && j>=0;i--,j--)
            if(board[i][j]==1)
                return false;
        for(i=row,j=col;j>=0 && i<N;i++,j++)
            if(board[i][j]==1)
                return false;
        return true;
    }
    // A recursive utility function to solve the N-Queens problem 
    static boolean solveNQueensUtil(int col,int N) {
        int i;
        if(col>=N)
            return true;
        for(i=0;i<N;i++) {
            if(isSafe(i,col,N)) {
                board[i][col]=1;
                if(solveNQueensUtil(col+1,N))
                    return true;
                board[i][col]=0;
            }
        }
        return false;
    }
    // This function solves the N-Queens problem using backtracking. It mainly uses solveNQueensUtil()
    static boolean solveNQueens(int N) {
        int i,j;
        for(i=0;i<N;i++)
            for(j=0;j<N;j++)
                board[i][j]=0;
        if(!solveNQueensUtil(0,N)) {
            System.out.println("Solution does not exist");
            return false;
        }
        printSolution(N);
        return true;
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (N): ");
        int N=sc.nextInt();
        solveNQueens(N);
        sc.close();
    }
}