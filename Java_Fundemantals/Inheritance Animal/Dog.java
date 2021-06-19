class Dog extends Animal {
    public String type = "mammal";

    public Dog(){
        super("animal");
        System.out.println("I am a dog");
    }
    public void display(){
        System.out.println("here is Dog class");
    }
    public void printMessage(){
        super.display();
        this.display();
    }
    public void printType(){
        System.out.println(super.type);
        System.out.println(this.type);
    }

}