import java.util.Scanner;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private double markCss;
    private double markHtml;
    private double markJs;
    private double markAvg;

    // Constructor
    public Student() {
    }

    public Student(String id, String firstName, String lastName, double markCss, double markHtml, double markJs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.markCss = markCss;
        this.markHtml = markHtml;
        this.markJs = markJs;
    }
    // get,set

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMarkCss() {
        return markCss;
    }

    public void setMarkCss(double markCss) {
        this.markCss = markCss;
    }

    public double getMarkHtml() {
        return markHtml;
    }

    public void setMarkHtml(double markHtml) {
        this.markHtml = markHtml;
    }

    public double getMarkJs() {
        return markJs;
    }

    public void setMarkJs(double markJs) {
        this.markJs = markJs;
    }

    public double getMarkAvg() {
        return markAvg;
    }
    // Tính điểm trung bình
    public  void calculateAvg(){
        markAvg = (markCss + markHtml + markJs)/3;
    }

    // Nhập thông tin cho học viên
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID học viên: ");
        id = sc.nextLine();
        System.out.println("Nhập firstName: ");
        firstName = sc.nextLine();
        System.out.println("Nhập lastName: ");
        lastName = sc.nextLine();
        System.out.println("Nhập markCss: ");
        markCss = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập markHtml: ");
        markHtml = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập markJs: ");
        markJs = Double.parseDouble(sc.nextLine());
        calculateAvg();
        System.out.println("Điểm trung bình: " + markAvg);

    }

    //　Hiển thị thông tin học viên
    public  void output(){
        String fullname = firstName + lastName;
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s \n", "id", "fullname", "markCss", "markHtml", "markJs","Điểm trung bình");
        System.out.printf("%-10s %-20s %-20f %-20f %-20f %-20f \n", id, fullname, markCss, markHtml, markJs, markAvg);
    }
}
