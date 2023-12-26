package ra.entity;

import ra.run.StudentManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudentManagement {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String classId;
    private List<Float> listMarkJavaScript = new ArrayList<>();
    private List<Float> listMarkJavaCore = new ArrayList<>();
    private List<Float> listMarkJavaWeb = new ArrayList<>();
    private float avgMark;
    private String gpa;
    private boolean studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, String classId, ArrayList<Float> listMarkJavaScript, ArrayList<Float> listMarkJavaCore, ArrayList<Float> listMarkJavaWeb, float avgMark, String gpa, boolean studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classId = classId;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.gpa = gpa;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(List<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public List<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(List<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public List<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(List<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin sinh viên:");
        // Nhập mã sinh viên
        inputStudentId(scanner);
        // Nhập tên sinh viên
        inputStudentName(scanner);
        // Nhập tuổi
        inputAge(scanner);
        // nhap gioi tinh
        inputSex(scanner);
        // Nhập vào lớp của sinh viên
        inputClass(scanner);
        // Nhập điểm javascript
        inputMark(scanner, "Javascript");
        // Nhập điểm javaCore
        inputMark(scanner, "Java Core");
        // Nhập điểm javaWeb
        inputMark(scanner, "Java Web");
        // Nhập vào trạng thái sinh viên
        inputStatus(scanner);


    }

    public void inputStudentId(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        do {
            this.studentId = scanner.nextLine();
            if (this.studentId.length() == 6 && this.studentId.startsWith("S")) {
                break;
            } else {
                System.out.println("Mã sinh viên gồm 6 ký tự bắt đầu là S, vui lòng nhập lại!");
            }
        } while (true);
    }

    public void inputStudentName(Scanner scanner) {
        System.out.print("Nhập tên sinh viên: ");
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.length() >= 20 && this.studentName.length() <= 50) {
                break;
            } else {
                System.out.println("Tên sinh viên gồm 20-50 ký tự,vui lòng nhập lại");
            }
        } while (true);

    }

    public void inputAge(Scanner scanner) {
        System.out.println("Nhập vào tuổi sinh viên:");
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if (this.age >= 18) {
                break;
            } else {
                System.out.println("Tuổi sinh viên lớn hơn hoặc bằng 18, vui lòng nhập lại!");
            }
        } while (true);
    }

    public void inputSex(Scanner scanner) {
        System.out.println("Nhập vào giới tính sinh viên:");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
    }

    public void inputClass(Scanner scanner) {
        System.out.println("Chọn lớp của sinh viên:");
        do {
            for (int i = 0; i < StudentManagement.listClass.size(); i++) {
                // In ra số thứ tự và tên lớp để chọn
                System.out.printf("%d.%s\n", (i + 1), StudentManagement.listClass.get(i).getClassName());
            }
            System.out.print("Chọn lớp:");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= StudentManagement.listClass.size()) {
                this.classId = StudentManagement.listClass.get(choice - 1).getClassId();
                break;
            } else {
                System.out.printf("Vui lòng chọn từ 1-%d\n", StudentManagement.listClass.size());
            }
        } while (true);
    }

    public void inputMark(Scanner scanner, String subjectName) {
        System.out.printf("Nhập vapf điểm %s:\n", subjectName);
        switch (subjectName) {
            case "Javascript":
                this.listMarkJavaScript.add(Float.parseFloat(scanner.nextLine()));
                break;
            case "Java Core":
                this.listMarkJavaCore.add(Float.parseFloat(scanner.nextLine()));
                break;
            case "Java Web":
                this.listMarkJavaWeb.add(Float.parseFloat(scanner.nextLine()));
                break;
        }
    }

    public void inputStatus(Scanner scanner) {
        System.out.println("Nhập vào trạng thái sinh viên:");
        this.studentStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Thông tin sinh viên:");
        System.out.printf("Mã SV: %s | Tên SV: %s | Tuổi SV: %d | Giới tính: %s\n",
                this.studentId, this.studentName, this.age, this.sex ? "Nam" : "Nữ");
        System.out.printf("Điểm Javascript: %f | Điểm Java Core: %f | Điểm Java Web: %f\n",
                this.listMarkJavaScript.get(this.listMarkJavaScript.size() - 1),
                this.listMarkJavaCore.get(this.listMarkJavaCore.size() - 1),
                this.listMarkJavaWeb.get(this.listMarkJavaWeb.size() - 1));
        System.out.printf("Điểm trung bình: %f | Xếp loại: %s | Trạng thái: %s\n",
                this.avgMark, this.gpa, this.studentStatus ? "Đang học" : "Thôi học");
    }

    public void calAvgMark() {
        this.avgMark = (this.listMarkJavaScript.get(this.listMarkJavaScript.size() - 1)
                + this.listMarkJavaCore.get(this.listMarkJavaCore.size() - 1)
                + this.listMarkJavaWeb.get(this.listMarkJavaWeb.size() - 1)) / 3;
    }

    public void getGPAByAvgMark() {
        if (this.avgMark < 5) {
            this.gpa = "Yếu";
        } else if (this.avgMark < 7) {
            this.gpa = "Trung bình";
        } else if (this.avgMark < 9) {
            this.gpa = "Khá";
        } else {
            this.gpa = "Giỏi";
        }
    }
}
