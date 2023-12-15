import Author.Author;
import Author.Authorservice;

import java.util.Scanner;

public class Libraly {

        /**
         * Viết chương trình Java quản lý thư viện. Quản lý 2 loại thông tin về sách và tác giả
         * Menu chính
         *      1. Quản lý tác giả
         *      2. Quản lý sách
         *      3. Thoát
         * Khi chọn menu 1. Quản lý tác giả
         *      1. Thêm tác giả
         *      2. Hiển thị tác giả
         *      3. Cập nhật thông tin tác giả (theo id)
         *      4. Xóa tác giả (Không xóa tác giả có đã sách)
         *      5. Quay lại (quay trở về menu chính)
         * Khi chọn menu 2. Quản lý sách
         *      1. Thêm sách
         *      2. Tìm kiếm sách theo tiêu đề
         *      3. Tìm kiếm sách theo tên tác giả
         *      4. Cập nhật sách (theo id)
         *      5. Quay lại (Quay về menu chính)
         */
        static Scanner scanner = new Scanner(System.in);
        static int choose;
        public static void main(String[] args) {


           /* do{
                System.out.println("Menu chính: ");
                System.out.println("1. Quản lý tác giả");
                System.out.println("2. Quản lý sách");
                System.out.println("3. Thoát");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:

                }

            }while (choose!=3);*/
        }


    /*    static void authorManagenment(){
            do {
                System.out.println("Menu quản lý tác giả: ");
                System.out.println("1. Thêm tác giả");
                System.out.println("2. Hiển thị tác giả");
                System.out.println("3. Cập nhật thông tin tác giả (theo id)");
                System.out.println("4. Xóa tác giả (Không xóa tác giả có đã sách)");
                System.out.println("5. Quay lại (quay trở về menu chính)");
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:

                }

            }while (choose!=5);
        }*/


}
