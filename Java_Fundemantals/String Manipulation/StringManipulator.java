public class StringManipulator{
    // public static void main(String [] args){
    //     System.out.println(trimAndConcat(" Sahar ", " Aws "));
    //     System.out.println(getIndexOrNull("sahar", 'q'));
    //     System.out.println(getIndexOrNull("Coding Dojo", "Aws"));
    //     System.out.println(concatSubstring("Hello", 1,2," Wolrd "));
    // }
    public static String trimAndConcat(String str1, String Str2){
        String new_str1= str1.trim();
        String new_str2= Str2.trim();
        String final_str= new_str1.concat(new_str2);
        return final_str;
    }
    public static Integer getIndexOrNull(String str, char c){
        Integer index = str.indexOf(c);
        if (index == -1){
            return null;
        }
        return index;
    }
    public static Integer getIndexOrNull(String str, String sub_string){
        Integer index = str.indexOf(sub_string);
        if (index == -1){
            return null;
        }
        return index;
    }
    public static String concatSubstring(String str1, int start, int end, String str2){
        String sub_string = str1.substring(start, end);
        return trimAndConcat(sub_string, str2);

    }
}