package lythuyet;

public abstract class Staff {
    private String name;
    private String id;
    private String email;

    public Staff() {
    }

    public Staff(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void report(){
        System.out.println("report");
    }
    public abstract void work();

}
