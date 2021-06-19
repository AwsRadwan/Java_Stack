import java.lang.Math;
public class Pythagorean{
    public static void main(String [] args){
        System.out.println(calculateHypotenuse(4, 3));
    }
    public static double calculateHypotenuse(int legA, int legB) {
        double squareRoot = Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
        return squareRoot;
    }
}