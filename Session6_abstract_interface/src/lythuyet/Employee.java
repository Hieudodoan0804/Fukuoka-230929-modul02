package lythuyet;

public class Employee extends Staff implements Service,ServiceData{
    @Override
    public void work() {
        System.out.println("working....");
    }

    @Override
    public void add(String item) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void input(String name) {

    }

    @Override
    public void output(String age) {

    }
}
