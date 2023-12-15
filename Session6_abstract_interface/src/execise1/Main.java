public class Main {
    public static void main(String[] args) {
        Person person = new Person("Nguyen Van A","Ha noi");
        System.out.println(person);

        Student student = new Student("Student name","Ha noi","online",2023,10000);
        System.out.println(student);
        Staff staff = new Staff("Staff name","Ha noi","Rikkei",1000);
        System.out.println(staff);
    }
}
