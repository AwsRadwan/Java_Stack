class ProjectClass {
    private String name;
    private String description;

    public String elevatorPitch(){
        String x =String.format("%s : %s" ,this.name, this.description);
        return x;
    }
    public ProjectClass() {
    }
    public ProjectClass(String name) {
        this.name = name;
    }
    
    public ProjectClass(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }

}