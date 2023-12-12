package Author;

import java.util.Arrays;
import java.util.Scanner;

public class Authorservice {
    private Author[] authors;
    private final int defaultElement = 10;
    private int index = 0;
    static Scanner scanner = new Scanner(System.in);
    public Authorservice(){
        authors = new Author[defaultElement];
    }
    public boolean addAuthor(Author at) {
        if (findId(at.getId()) == null){
            if (index==authors.length){
                authors= Arrays.copyOf(authors,authors.length+defaultElement);
            }
            authors[index++] = at;
            return true;
        }
        return false;
    }
    public boolean edit(Author at){
        Author editAuthor = findId(at.getId());
        if (editAuthor!=null){
            System.out.println("Nhập tên tác giả: ");
            editAuthor.setName(scanner.nextLine());
            System.out.println("Nhập email: ");
            editAuthor.setEmail(scanner.nextLine());
            System.out.println("Nhập tuổi: ");
            editAuthor.setAge(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Nhập giới tính: ");
            editAuthor.setGender(scanner.nextLine());
            return true;
        }
        System.out.println("Không có tác giả trong danh sách");
        return false;
    }

    public Author input(){
        Author at = new Author();
        System.out.println("Nhập id tác giả:");
        at.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên tác giả:");
        at.setName(scanner.nextLine());
        System.out.println("Nhập email tác giả:");
        at.setEmail(scanner.nextLine());
        System.out.println("Nhập gender tác giả:");
        at.setGender(scanner.nextLine());
        System.out.println("Nhập age tác giả:");
        at.setAge(scanner.nextInt());
        scanner.nextLine();
        return at;
    }

    public Author findId(int id){
        for (int i = 0; i < index; i++){
            if (authors[i].getId().equals(id)){
                return authors[i];
            }
        }
        return null;
    }
    public void showAuthor(){
        for (int i = 0; i < index; i++) {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s\n", "id", "Name", "Email", "Gender", "Age");
            System.out.printf("%-10d %-20s %-20s %-20s %-20d\n",authors[i].getId(), authors[i].getName(), authors[i].getEmail(), authors[i].getGender(), authors[i].getAge());
        }
    }
}
