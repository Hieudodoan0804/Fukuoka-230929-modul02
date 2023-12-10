import java.util.Scanner;

public class Author {
    private String id;
    private String name;
    private String email;
    private String gender;
    private int age;
    private Author[] authors;

    public Author() {
    }

    public Author(String id, String name, String email, String gender, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id tác giả:");
        id =scanner.nextLine();
        System.out.println("Nhập tên tác giả:");
        name = scanner.nextLine();
        System.out.println("Nhập email tác giả:");
        email = scanner.nextLine();
        System.out.println("Nhập gender tác giả:");
        gender = scanner.nextLine();
        System.out.println("Nhập age tác giả:");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("Tác giả đã được thêm thành công.");
    }




}
