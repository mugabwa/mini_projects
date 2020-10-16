
import java.util.*;
public class Pancake {
    //Sorting code
    static void swip(int arr[], int i) 
    { 
        int temp, start = 0; 
        while (start < i) 
        { 
            temp = arr[start]; 
            arr[start] = arr[i]; 
            arr[i] = temp; 
            start++; 
            i--; 
        } 
    } 
    
    static int maxValue(int x[], int len) 
    { 
        int mid=0; 
        for (int i = 0; i < len; ++i) 
            if (x[i] > x[mid]) 
                mid = i; 
        return mid; 
    } 
  
    static int sort(int x[], int len) 
    {  
        for (int curr_size = len; curr_size > 1; --curr_size) 
        {  
            int mid = maxValue(x, curr_size); 
   
            if (mid != curr_size-1) 
            {  
                swip(x, mid); 
                swip(x, curr_size-1); 
            } 
        } 
        return 0; 
    } 
  
  
    // Drive Code
    public static void main (String[] args) 
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
