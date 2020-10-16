
public class Matrix {
    //The main function
    public static void main(String[] args){
        //declaring and initializing 2D arrays
        int[][] A = {{1,2,3,4,5,6},{4,3,7,4,1,3},{3,2,4,7,5,1},{4,1,6,4,5,1},{1,7,4,3,2,5},{2,7,6,3,2,4}};
        int[][] B = {{1,2,3,4,5,1},{0,4,3,2,1,1},{3,3,3,0,5,1},{4,1,1,4,5,1},{1,1,1,3,2,1},{2,1,2,1,2,1}};
        int[][] M = new int[6][6];
        //For loop for displaying matrix A
        for(int i=0;i<6;++i){
            for(int j=0;j<6;++j){
                System.out.printf("%d ",A[i][j]);
                A[i][j] *= 2;       //Scalar multiplication of the matrix
            }
            System.out.println();
        }
        System.out.println();       //Line separator
        //For loop for displaying matrix A after scalar multiplication
        for(int i=0;i<6;++i){
            for(int j=0;j<6;++j){
                System.out.printf("%d ",A[i][j]);
            }
            System.out.println();
        }
        //Multiplication of two matrices
        for(int i=0;i<6;++i){
            for(int j=0;j<6;++j){
                M[i][j] = 0;
                for(int k=0;k<6;++k){
                    M[i][j] = M[i][j] + A[i][k]*B[k][j];
                }
            }
        }
        System.out.println();
        //Displaying matrix M
        for(int i=0;i<6;++i){
            for(int j=0;j<6;++j){
                System.out.printf("%d ",M[i][j]);
            }
            System.out.println();
        }
    }
}
