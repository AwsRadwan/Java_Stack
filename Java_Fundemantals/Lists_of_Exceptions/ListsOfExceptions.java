import java.util.ArrayList;
public class ListsOfExceptions {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        listsOfExceptions(myList);
    }
    public static void listsOfExceptions(ArrayList myList){
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } 
            catch (Exception e){
                System.out.println("The variable is not able to casting");
            }
        }
    }
}