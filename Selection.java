
import java.util.Random;

public class Selection {
    static void sort(int arr[], int len) 
    {   
        for (int i = 0; i < len-1; i++) 
        {  
            int min = i; 
            for (int j = i+1; j < len; j++) 
                if (arr[j] < arr[min]) 
                    min = j;  
            int temp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
  
  
    // Driver code to test above 
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
