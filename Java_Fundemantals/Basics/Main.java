import java.util.ArrayList;
import java.util.Arrays;
public class Main{
    public static void main(String [] args){
        BasicJava result = new BasicJava();
        int[] arr = {1,2,3,4,7,9,77,-1,5,-10};
        String x = Arrays.toString(arr);
        // result.printNumbers();
        // result.printOddNumbers();
        // result.printNumbersAndSummations();
        // result.loopInArray(arr);
        // System.out.println(result.findMax(arr));
        // System.out.println(result.getAverage(arr));
        // System.out.println(result.numberGreaterThan(arr,5));
        // System.out.println(Arrays.toString(result.squareTheValues(arr)));
        // System.out.println(Arrays.toString(result.eliminateNegativeNumbers(arr)));
        // System.out.println(Arrays.toString(result.maxMinAvg(arr)));
        System.out.println(Arrays.toString(result.shiftArray(arr)));
    }
}