import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class btvn {
    public static void main(String[] args) {
        /**
         * Viết chương trình java, nhập vào danh sách email của 10 bạn trong lớp.
         * Có kiểm tra định dạng email.
         * Hiển thị email của các bạn trong lớp theo thứ tự A-Z, định dạng bảng giống như sau:
         *  +----------------------+
         *  |   Danh sách email    |
         *  +----------------------+
         *  | trunghv@gmail.com    |
         *  | trunghv.lsd@gmail.com|
         *  | trung.abc@gmail.com  |
         *  | trunghv@gmail.com    |
         *  +----------------------+
         */
        Scanner sc = new Scanner(System.in);
        Pattern validEmail = Pattern.compile("^[\\w.]+@[\\w.-]+\\.[a-z]{2,4}$");
        String[] listEmail = new String[10];
        String temp;
            for (int i=0;i<10;i++){
                do {
                    System.out.print("Nhập email thứ "+(i+1)+":");
                    listEmail[i] = sc.nextLine();
                }while (!validEmail.matcher(listEmail[i]).matches());
            }
            for (int i = 0; i < 10; i++)
            {
                for (int j = i + 1; j < 10; j++) {
                    if (listEmail[i].compareTo(listEmail[j])>0)
                    {
                        temp = listEmail[i];
                        listEmail[i] = listEmail[j];
                        listEmail[j] = temp;
                    }
                }
            }
        System.out.println("+----------------------+");
        System.out.println("|    Danh sách email   |");
        System.out.println("+----------------------+");
        for (int i=0;i<10;i++){
            System.out.println("|  "+listEmail[i]+"    |");
        }
        System.out.println("+----------------------+");



    }
}
