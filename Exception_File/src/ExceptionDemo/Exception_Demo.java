package ExceptionDemo;

import java.util.Scanner;

public class Exception_Demo {
    public static void main(String[] args) {
        /*
        * Nhập vào điểm sinh viên có kiểu dữ liệu là số thực, giá trị từ 0-10
        * Nhập vào tuổi sinh viên có kiểu dữ liệu là số nguyên , giá trị >=18
        * */
        Scanner scanner = new Scanner(System.in);
        float mark;
        int age;
        do {
            System.out.println("Nhập vào điểm sinh viên:");
            try {
                mark = Float.parseFloat(scanner.nextLine());
                if (mark>=0 && mark <=10){
                    break;
                }else {
                    System.out.println("Điểm trong khoảng 0-10, vui lòng nhập lại!");
                }

            }catch (NumberFormatException numberFormatException){
                System.out.println("Điểm có định dạng là số thực, vui lòng nhập lại!");
            }

        }while (true);

        do {
            System.out.println("Nhập vào tuổi sinh viên:");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age>=18){
                    break;
                }else {
                    System.out.println("Tuổi lớn hơn 18, vui lòng nhập lại!");
                }

            }catch (NumberFormatException numberFormatException){
                System.out.println("Tuổi có định dạng số nguyên vui lòng nhập lại!");
            }

        }while (true);
    }
}
