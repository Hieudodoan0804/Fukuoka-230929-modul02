package ra.entity;

import java.util.Scanner;

public class StudentClass implements IStudentManagement {
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {
    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    //0: chờ lớp - 1: hoạt động - 2: tạm dừng - 3: Kết thúc
    @Override
    public void inputData(Scanner scanner) {
        // Nhập mã lớp
        inputClassId(scanner);
        // Nhập tên lớp
        inputClassName(scanner);
        // Nhập mô tả lớp
        inputDescription(scanner);
        // Nhập trạng thái lớp
        inputStatus(scanner);
    }

    public void inputClassId(Scanner scanner) {
        System.out.println("Nhập vào mã lớp:");
        do {
            this.classId = scanner.nextLine();
            if (this.classId.matches("J\\w{4}")) {
                break;
            } else {
                System.out.println("Mã lớp phải gồm 5 ký tự , bắt đầu là J, vui lòng nhập lại!");
            }
        } while (true);
    }

    public void inputClassName(Scanner scanner) {
        System.out.println("Nhập vào tên lớp:");
        do {
            this.className = scanner.nextLine();
            if (this.className.matches("^.{1,10}$")) {
                break;
            } else {
                System.out.println("Tên lớp tối đa 10 ký tự, vui lòng nhập lại!");
            }
        } while (true);
    }

    public void inputDescription(Scanner scanner) {
        System.out.println("Nhập vào mô tả lớp:");
        this.descriptions = scanner.nextLine();
    }

    public void inputStatus(Scanner scanner) {
        System.out.println("Chọn trạng thái lớp:");
        do {
            System.out.println("0. Chờ lớp");
            System.out.println("1. Hoạt động");
            System.out.println("2. Tạm dừng");
            System.out.println("3. Kết thúc");
            System.out.print("Lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 0 && choice <= 3) {
                this.classStatus = choice;
                break;
            } else {
                System.out.println("Vui lòng chọn từ 0-3");
            }
        } while (true);
    }

    @Override
    public void displayData() {
        String status;
        switch (this.classStatus) {
            case 0:
                status = "Chờ lớp";
                break;
            case 1:
                status = "Hoạt động";
                break;
            case 2:
                status = "Tạm dừng;";
                break;
            default:
                status = "Kết thúc";
        }
        System.out.printf("Mã lớp: %s - Tên lớp: %s - Mô tả: %s - Trạng thái: %s\n",
                this.classId, this.className, this.descriptions, status);
    }

}
