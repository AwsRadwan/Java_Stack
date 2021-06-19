public class StringManipulatorTest {
    public static void main(String [] args){
        StringManipulator str= new StringManipulator();
        System.out.println(str.trimAndConcat(" Sahar ", " Aws "));
        System.out.println(str.getIndexOrNull("sahar", 'q'));
        System.out.println(str.getIndexOrNull("Coding Dojo", "Aws"));
        System.out.println(str.concatSubstring("Hello", 1,2," Wolrd "));
    }
}