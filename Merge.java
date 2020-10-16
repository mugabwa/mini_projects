
import java.util.Random;


public class Merge {
    static void merge(int x[], int left, int mid, int right) 
    { 
        int n1 = mid - left + 1; 
        int n2 = right - mid; 
        int Left[] = new int[n1]; 
        int Right[] = new int[n2]; 
        for (int i = 0; i < n1; ++i) 
            Left[i] = x[left + i]; 
        for (int j = 0; j < n2; ++j) 
            Right[j] = x[mid + 1 + j]; 
  
        /* Merge the arrays */
        int i = 0, j = 0; 
        int k = left; 
        while (i < n1 && j < n2) { 
            if (Left[i] <= Right[j]) { 
                x[k] = Left[i]; 
                i++; 
            } 
            else { 
                x[k] = Right[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1) { 
            x[k] = Left[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) { 
            x[k] = Right[j]; 
            j++; 
            k++; 
        } 
    } 
  
     
    static void sort(int x[], int left, int right) 
    { 
        if (left < right) {  
            int mid = (left + right) / 2;  
            sort(x, left, mid); 
            sort(x, mid + 1, right);  
            merge(x, left, mid, right); 
        } 
    } 
   
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int w[]= new int[1000], x[]= new int[10000], y[]= new int[100000],z[]= new int[1000000];
        int n[] = {1000,10000,100000,1000000}; 
        Random random = new Random();
        for(int i=0;i<1000;++i){
            w[i]=random.nextInt();
        }
        for(int i=0;i<10000;++i){
            x[i]=random.nextInt();
        }
        for(int i=0;i<100000;++i){
            y[i]=random.nextInt();
        }
        for(int i=0;i<1000000;++i){
            z[i]=random.nextInt();
        }  
        long startTime = System.nanoTime();
        sort(w,0,n[0]-1);
        long stopTime = System.nanoTime();
        long elapsedTime1 = stopTime-startTime;
        startTime = System.nanoTime();
        sort(x,0,n[1]-1);
        stopTime = System.nanoTime();
        long elapsedTime2 = stopTime-startTime;
        startTime = System.nanoTime();
        sort(y,0,n[2]-1);
        stopTime = System.nanoTime();
        long elapsedTime3 = stopTime-startTime;
        startTime = System.nanoTime();
        sort(z,0,n[3]-1);
        stopTime = System.nanoTime();
        long elapsedTime4 = stopTime-startTime;
        System.out.println("Exectuion time for 1000 is: "+elapsedTime1 +"nanoseconds");
        System.out.println("Exectuion time for 10000 is: "+elapsedTime2 +"nanoseconds");
        System.out.println("Exectuion time for 100000 is: "+elapsedTime3 +"nanoseconds");
        System.out.println("Exectuion time for 1000000 is: "+elapsedTime4 +"nanoseconds"); 
    } 
}
