
import java.util.Random;


public class Quick {
    static int part(int[] x, int min, int max) 
    { 
        int pivot = x[max];  
        int i = (min-1); 
        for (int j=min; j<max; j++) 
        {  
            if (x[j] < pivot) 
            { 
                i++;  
                int temp = x[i]; 
                x[i] = x[j]; 
                x[j] = temp; 
            } 
        }  
        int temp = x[i+1]; 
        x[i+1] = x[max]; 
        x[max] = temp; 
        return i+1; 
    } 
    static void quick_sort(int x[], int min, int max){
        if (min < max) 
        { 
            int subarray = part(x, min, max); 
            quick_sort(x, min, subarray-1); 
            quick_sort(x, subarray+1, max); 
        }
    }
    
    // Driver program 
    public static void main(String args[]) 
    { 
        int[] w= new int[1000];
        int[] x= new int[10000];
        int[] y= new int[100000];
        int[] z= new int[1000000];
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
        quick_sort(w,0,n[0]-1);
        long stopTime = System.nanoTime();
        long elapsedTime1 = stopTime-startTime;
        startTime = System.nanoTime();
        quick_sort(x,0,n[1]-1);
        stopTime = System.nanoTime();
        long elapsedTime2 = stopTime-startTime;
        startTime = System.nanoTime();
        quick_sort(y,0,n[2]-1);
        stopTime = System.nanoTime();
        long elapsedTime3 = stopTime-startTime;
        startTime = System.nanoTime();
        quick_sort(z,0,n[3]-1);
        stopTime = System.nanoTime();
        long elapsedTime4 = stopTime-startTime;
        System.out.println("Exectuion time for 1000 is: "+elapsedTime1 +"nanoseconds");
        System.out.println("Exectuion time for 10000 is: "+elapsedTime2 +"nanoseconds");
        System.out.println("Exectuion time for 100000 is: "+elapsedTime3 +"nanoseconds");
        System.out.println("Exectuion time for 1000000 is: "+elapsedTime4 +"nanoseconds");
    } 
}
