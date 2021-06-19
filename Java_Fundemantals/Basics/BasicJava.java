import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class BasicJava {
    public static void printNumbers(){
        // ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<256; i++){
            System.out.println(i);
            // list.add(i);
        }
    }
    public static void printOddNumbers(){
        for (int i=1; i<256; i++){
            if (i%2 == 1){
                System.out.println(i);
            }
        }
    }
    public static void printNumbersAndSummations(){
        Integer sum = 0;
        for (int i=0; i<256; i++){
            sum += i;
            String out = "New Number: "+i+", Sum: "+sum;
            System.out.println(out);
        }
    }
    public static void loopInArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static Integer findMax(int[] arr){
        Integer max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static double getAverage(int[] arr){
        double avg;
        double sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        avg = sum/arr.length;
        return avg;
    }
    public static Integer numberGreaterThan(int[] arr, int y){
        Integer c =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>y){
                c++;
            }
        }
        return c;
    }
    public static int[] squareTheValues(int[] arr){
        for(int i = 0; i<arr.length; i++){
            arr[i] *= arr[i];
        }
        // String x = Arrays.toString(arr);
        return arr;
    }
    public static int[] eliminateNegativeNumbers(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                arr[i] = 0;
            }
        }
        return arr;
    }
    public static double[] maxMinAvg(int[] arr){
        double avg;
        int max=arr[0], min=arr[0], sum = 0;
        // int min=arr[0];
        // int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
            sum += arr[i];
        }
        double s = sum, maxx = max, minn = min;
        avg = s/arr.length;
        double[] ar = {maxx, minn, avg};
        return ar;
    }
    public static int[] shiftArray(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;
        return arr;
    }
}