import java.util.*;
public class Bucket {
    static void sort(float x[], int len) 
    { 
        if (len <= 0) 
            return; 
        // 1) Create buckets 
        @SuppressWarnings("unchecked") 
        Vector<Float>[] buckets = new Vector[len]; 
        for (int i = 0; i < len; i++) { 
            buckets[i] = new Vector<Float>(); 
        } 
        // move arrays to different buckets 
        for (int i = 0; i < len; i++) { 
            float idx = x[i] * len; 
            buckets[(int)idx].add(x[i]); 
        } 
        // bucket sorting 
        for (int i = 0; i < len; i++) { 
            Collections.sort(buckets[i]); 
        } 
        // join buckets 
        int index = 0; 
        for (int i = 0; i < len; i++) { 
            for (int j = 0; j < buckets[i].size(); j++) { 
                x[index++] = buckets[i].get(j); 
            } 
        } 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        float w[]= new float[1000], x[]= new float[10000], y[]= new float[100000],z[]= new float[1000000];
        int n[] = {1000,10000,100000,1000000}; 
        Random random = new Random();
        for(int i=0;i<1000;++i){
            w[i]=random.nextFloat();
        }
        for(int i=0;i<10000;++i){
            x[i]=random.nextFloat();
        }
        for(int i=0;i<100000;++i){
            y[i]=random.nextFloat();
        }
        for(int i=0;i<1000000;++i){
            z[i]=random.nextFloat();
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
