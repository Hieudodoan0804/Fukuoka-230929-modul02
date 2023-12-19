package lythuyet.vidu;

public class Employee implements BaseEntity {
    String id;
    String name;
    String salary;

    public Employee(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public void input() {

    }

    @Override
    public void show() {

    }

    @Override
    public boolean checkId(Object id) {
        return id.equals(id);
    }
}
