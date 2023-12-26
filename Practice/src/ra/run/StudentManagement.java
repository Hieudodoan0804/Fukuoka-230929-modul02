package ra.run;

import ra.entity.IStudentManagement;
import ra.entity.Student;
import ra.entity.StudentClass;

import java.util.*;

public class StudentManagement {
    public static List<StudentClass> listClass = new ArrayList<>();
    public static List<Student> listStudents = new ArrayList<>();

    public StudentManagement() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.showMenu(scanner);
    }

    public void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("**********************QUẢN LÝ HỌC VIỆN*******************");
            System.out.println("1. Quản lý lớp");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.manageClassMenu(scanner);
                    break;
                case 2:
                    StudentManagement.manageStudentMenu(scanner);
                    break;
                case 3:
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void manageClassMenu(Scanner scanner) {
        boolean isExist = true;
        while (isExist) {
            System.out.println("**********************QUẢN LÝ LỚP HỌC********************");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Cập nhật thông tin lớp học");
            System.out.println("3. Hiển thị thông tin lớp học");
            System.out.println("4. Thống kê các lớp học đang hoạt động");
            System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.addNewClass(scanner);
                    break;
                case 2:
                    StudentManagement.updateClassInfo(scanner);
                    break;
                case 3:
                    StudentManagement.displayClassInfo();
                    break;
                case 4:
                    StudentManagement.showActiveClasses();
                    break;
                case 5:
                    StudentManagement.searchClassByName(scanner);
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void addNewClass(Scanner scanner) {
        System.out.println("Nhập vào số lớp học cần nhập thông tin:");
        int numberOfClass = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfClass; i++) {
            StudentClass studentClass = new StudentClass();
            studentClass.inputData(scanner);
            listClass.add(studentClass);
        }
    }

    public static void updateClassInfo(Scanner scanner) {
        System.out.println("Nhập vào mã lớp học cần cập nhật thông tin:");
        String claIdUpdate = scanner.nextLine();
        int indexUpdate = getIndexByClassId(claIdUpdate);
        if (indexUpdate >= 0) {
            // Tìm thấy lớp cần cập nhật --> Tiến hành cập nhật
            listClass.get(indexUpdate).inputClassName(scanner);
            listClass.get(indexUpdate).inputDescription(scanner);
            listClass.get(indexUpdate).inputStatus(scanner);
        } else {
            System.out.printf("Lớp %s không tìm thấy, vui lòng nhập lại\n", claIdUpdate);
        }
    }

    public static int getIndexByClassId(String classId) {
        for (int i = 0; i < listClass.size(); i++) {
            if (listClass.get(i).getClassId().equals(classId)) {
                return i;
            }
        }
        // Không tìm thấy mã lớp trong listClass
        return -1;
    }

    public static void displayClassInfo() {
        for (StudentClass studentClass : listClass) {
            studentClass.displayData();
        }
    }

    public static void showActiveClasses() {
        int countClass = 0;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassStatus() == 1) {
                countClass++;
            }
        }
        System.out.printf("Có %d lớp đang hoạt động\n", countClass);
    }

    public static void searchClassByName(Scanner scanner) {
        System.out.println("Nhập vào tên lớp cần tìm:");
        String className = scanner.nextLine();
        int countClass = 0;
        for (StudentClass studentClass : listClass) {
            if (studentClass.getClassName().toLowerCase().contains(className.toLowerCase())) {
                studentClass.displayData();
                countClass++;
            }
        }
        System.out.printf("Tìm thấy %d lớp có chứa %s\n", countClass, className);
    }

    public static void manageStudentMenu(Scanner scanner) {
        boolean isExist = true;
        while (isExist) {
            System.out.println("***********************QUẢN LÝ SINH VIÊN******************");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Tính điểm trung bình");
            System.out.println("5. Xếp loại sinh viên");
            System.out.println("6. Sắp xếp sinh viên theo điểm trung bình tăng dần");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình và yếu");
            System.out.println("9. Thống kê các sinh viên Pass qua các môn học");
            System.out.println("10. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.addNewStudent(scanner);
                    break;
                case 2:
                    StudentManagement.updateStudentInfo(scanner);
                    break;
                case 3:
                    StudentManagement.displayStudentInfo();
                    break;
                case 4:
                    StudentManagement.calculateAvgMark();
                    break;
                case 5:
                    StudentManagement.classifyStudents();
                    break;
                case 6:
                    StudentManagement.sortStudentsByAvgMark();
                    break;
                case 7:
                    StudentManagement.searchStudentByName(scanner);
                    break;
                case 8:
                    StudentManagement.statisticsByGrade();
                    break;
                case 9:
                    StudentManagement.statisticsPassingStudents();
                    break;
                case 10:
                    isExist = false;
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void addNewStudent(Scanner scanner) {
        System.out.println("Nhập vào số sinh viên cần nhập thông tin:");
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student();
            student.inputData(scanner);
            listStudents.add(student);
        }
    }

    public static void updateStudentInfo(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên cần cập nhật:");
        String studentIdUpdate = scanner.nextLine();
        int indexUpdate = getIndexByStudentId(studentIdUpdate);
        if (indexUpdate >= 0) {
            listStudents.get(indexUpdate).inputStudentName(scanner);
            listStudents.get(indexUpdate).inputAge(scanner);
            listStudents.get(indexUpdate).inputSex(scanner);
            listStudents.get(indexUpdate).inputClass(scanner);
            listStudents.get(indexUpdate).inputMark(scanner, "Javascript");
            listStudents.get(indexUpdate).inputMark(scanner, "Java Core");
            listStudents.get(indexUpdate).inputMark(scanner, "Java Web");
            listStudents.get(indexUpdate).inputStatus(scanner);
            System.out.println("Thông tin sinh viên đã được cập nhật!");
        } else {
            System.out.println("Không tìm thấy mã sinh viên " + studentIdUpdate);
        }
    }

    public static int getIndexByStudentId(String studentId) {
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).getStudentId().equals(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public static void displayStudentInfo() {
        listStudents.forEach(student -> student.displayData());
    }

    public static void calculateAvgMark() {
        listStudents.forEach(student -> student.calAvgMark());
    }

    public static void classifyStudents() {
        listStudents.forEach(student -> student.getGPAByAvgMark());
    }

    public static void sortStudentsByAvgMark() {
        Collections.sort(listStudents, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.getAvgMark() > t1.getAvgMark()) {
                    return 1;
                } else if (student.getAvgMark() == t1.getAvgMark()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }

    public static void searchStudentByName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String studentName = scanner.nextLine();
        int countStudents = 0;
        for (Student student : listStudents) {
            if (student.getStudentName().toLowerCase().contains(studentName.toLowerCase())) {
                student.displayData();
                countStudents++;
            }
        }
        System.out.printf("Tìm thấy %d sinh viên có tên chứa %s\n", countStudents, studentName);
    }

    public static void statisticsByGrade() {
        int numberOfWeak = 0;
        int numberOfAverage = 0;
        int numberOfNormal = 0;
        int numberOfGood = 0;
        for (Student student : listStudents) {
            switch (student.getGpa()) {
                case "Yếu":
                    numberOfWeak++;
                    break;
                case "Trung bình":
                    numberOfAverage++;
                    break;
                case "Khá":
                    numberOfNormal++;
                    break;
                case "Giỏi":
                    numberOfGood++;
                    break;
            }
        }
        System.out.printf("Giỏi: %d | Khá: %d | Trung bình: %d | Yếu: %d\n",
                numberOfGood, numberOfNormal, numberOfAverage, numberOfWeak);
    }

    public static void statisticsPassingStudents() {
        int numberOfPass = 0;
        for (Student student : listStudents) {
            if (student.getAvgMark() >= IStudentManagement.MARK_PASS) {
                numberOfPass++;
            }
        }
        System.out.printf("Có %d sinh viên qua môn\n", numberOfPass);
    }
}
