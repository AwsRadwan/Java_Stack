import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class PuzzleJava {
    public static void main(String [] args){
        PuzzleJava output = new PuzzleJava();
        int[] arr = {3,5,1,2,7,9,8,13,25,32};
        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        // System.out.println(output.greaterThanTen(arr));
        // System.out.println(output.namesShuffle(names));
        // System.out.println(output.tenRandom());
        // System.out.println(output.tenRandomSorted());
        // output.alfaShuffle(alphabet);
        // System.out.println(output.randomString(alphabet));
        System.out.println(Arrays.toString(output.tenRandomStrings()));
    }
    public static ArrayList greaterThanTen(int[] arr){
        int sum=0;
        ArrayList<Integer> listarr = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>10){
                listarr.add(arr[i]);
            }
            sum += arr[i];
        }
        System.out.println(sum);
        return listarr;
    }
    public static ArrayList namesShuffle(String[] names){
        List<String> strList = Arrays.asList(names);
        Collections.shuffle(strList);
        ArrayList<String> namess = new ArrayList<String>();
        for(int i=0; i<names.length; i++){
            System.out.println(names[i]);
            if(names[i].length()>5){
                namess.add(names[i]);
            }
        }
        return namess;
    }
    public static ArrayList tenRandom(){
        ArrayList<Integer> rnum = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            int b = (int)(Math.random()*(100-55+1)+55);
            rnum.add(b);
        }
        return rnum;
    }
    public static ArrayList tenRandomSorted(){
        ArrayList<Integer> rnum = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            int b = (int)(Math.random()*(100-55+1)+55);
            rnum.add(b);
        }
        Collections.sort(rnum);
        System.out.println("Max = "+rnum.get(9)+", Min = "+rnum.get(0));
        return rnum;
    }
    public static void alfaShuffle(Character[] arr){
        List<Character> alpha = Arrays.asList(arr);
        Collections.shuffle(alpha);
        System.out.println(alpha);
        System.out.println(arr[0]);
        System.out.println(arr[arr.length-1]);
        if(arr[0].equals('a') || arr[0].equals('i') || arr[0].equals('u') || arr[0].equals('e') || arr[0].equals('o')){
            System.out.println("The First Letter is Vowel !!");
        }
    }
    public static String randomString(Character[] arr){
        // ArrayList<Integer> rstr = new ArrayList<Integer>();
        List<Character> alpha = Arrays.asList(arr);
        Collections.shuffle(alpha);
        Random r = new Random();
        String ran = "";
        for(int i=0; i<5; i++){
            int x = r.nextInt(26);
            String c = Character.toString(arr[x]);
            ran = ran + c;
        }
        return ran;
    }
    public static String[] tenRandomStrings(){
        String[] tenStr = {};
        for(int i=0; i<10; i++){
            Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            String c = randomString(alphabet);
            tenStr = Arrays.copyOf(tenStr, tenStr.length + 1);
            tenStr[tenStr.length - 1] = c;
        }
        return tenStr;
    }
}