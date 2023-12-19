package lythuyet.vidu;

public class Student implements BaseEntity {
    String name;
    String id;
    String className;

    public Student(String name, String id, String className) {
        this.name = name;
        this.id = id;
        this.className = className;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public void input() {

    }

    @Override
    public void show() {
        System.out.println("Id: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Class name: " + this.className);
    }

    @Override
    public boolean checkId(Object id) {
        boolean check = id.equals(this.id);
        return check;
    }
}
