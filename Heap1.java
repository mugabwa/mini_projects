
import java.util.Random;


public class Heap1 {
    //Sorting code
    static void sort(int x[],int len) 
    { 
        for (int i = len / 2 - 1; i >= 0; i--) 
            heap_formation(x, len, i); 
        // Element extraction from heap 
        for (int i=len-1; i>0; i--) 
        { 
            // Moves current root to end 
            int temp = x[0]; 
            x[0] = x[i]; 
            x[i] = temp;  
            heap_formation(x, i, 0); 
        } 
    } 

    static void heap_formation(int x[], int len, int itr) 
    { 
        int largest = itr; 
        int left = 2*itr + 1;
        int right = 2*itr + 2; 
  
        // If left child>root 
        if (left < len && x[left] > x[largest]) 
            largest = left; 
  
        // If right child>largest 
        if (right < len && x[right] > x[largest]) 
            largest = right; 
  
        // If largest is not root 
        if (largest != itr) 
        { 
            int swap = x[itr]; 
            x[itr] = x[largest]; 
            x[largest] = swap;  
            heap_formation(x, len, largest); 
        } 
    } 
  
  
    // Driver code 
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
        sort(w,n[0]);
        long stopTime = System.nanoTime();
        long elapsedTime1 = stopTime-startTime;
        startTime = System.nanoTime();
        sort(x,n[1]);
        stopTime = System.nanoTime();
        long elapsedTime2 = stopTime-startTime;
        startTime = System.nanoTime();
        sort(y,n[2]);
        stopTime = System.nanoTime();
        long elapsedTime3 = stopTime-startTime;
        startTime = System.nanoTime();
        sort(z,n[3]);
        stopTime = System.nanoTime();
        long elapsedTime4 = stopTime-startTime;
        System.out.println("Exectuion time for 1000 is: "+elapsedTime1 +"nanoseconds");
        System.out.println("Exectuion time for 10000 is: "+elapsedTime2 +"nanoseconds");
        System.out.println("Exectuion time for 100000 is: "+elapsedTime3 +"nanoseconds");
        System.out.println("Exectuion time for 1000000 is: "+elapsedTime4 +"nanoseconds");
    } 
}
