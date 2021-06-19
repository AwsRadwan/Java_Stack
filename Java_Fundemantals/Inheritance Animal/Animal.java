public class Animal {
    public String type = "animal";

    public Animal(){
        System.out.println("I am an animal");
    }

    public Animal(String type){
        this.type = type;
        System.out.println("Type: " + type);
    }
    public void display(){
        System.out.println("here is Animal class");
    }

}