import java.util.Scanner;

public class btvn {
    public static void main(String[] args) {
        // BTVN: Giả sử bạn đang tham gia viết chương trình cho máy đo chiều cao cân nặng, hãy viết
        //một chương trình có khả năng đọc các số nguyên không âm có tối đa 3 chữ số.
        //Ví dụ, với số 261, chương trình in ra màn hình two hundred and sixty one.
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Nhâp vào một số nguyên dương:");
        number=sc.nextInt();
        if (number<0||number>999){
            System.out.println("Hãy nhập lại!");
        }
        else {
            int units=number%10;
            int tens =(number/10)%10;
            int hundreds=number/100;
            switch (hundreds){
                case 1:
                    System.out.println("Một trăm ");
                    break;
                case 2:
                    System.out.println("Hai trăm");
                    break;
                case 3:
                    System.out.println("Ba trăm");
                    break;
                case 4:
                    System.out.println("Bốn trăm");
                    break;
                case 5:
                    System.out.println("Năm trăm");
                    break;
                case 6:
                    System.out.println("Sáu trăm");
                    break;
                case 7:
                    System.out.println("Bảy trăm");
                    break;
                case 8:
                    System.out.println("Tám trăm");
                    break;
                case 9:
                    System.out.println("Chín trăm");
                    break;
            }
            if (tens%10==0&&units!=0){
                switch (tens){
                    case 1:
                        System.out.println("mười");
                        break;
                    case 2:
                        System.out.println("hai mươi");
                        break;
                    case 3:
                        System.out.println("ba mươi");
                        break;
                    case 4:
                        System.out.println("bốn mươi");
                        break;
                    case 5:
                        System.out.println("năm mươi");
                        break;
                    case 6:
                        System.out.println("sáu mươi");
                        break;
                    case 7:
                        System.out.println("bảy mươi");
                        break;
                    case 8:
                        System.out.println("tám mươi");
                        break;
                    case 9:
                        System.out.println("chín mươi");
                        break;
                }
                switch (units){
                    case 1:
                        System.out.println("một");
                        break;
                    case 2:
                        System.out.println("hai");
                        break;
                    case 3:
                        System.out.println("ba");
                        break;
                    case 4:
                        System.out.println("bốn");
                        break;
                    case 5:
                        System.out.println("năm");
                        break;
                    case 6:
                        System.out.println("sáu");
                        break;
                    case 7:
                        System.out.println("bảy");
                        break;
                    case 8:
                        System.out.println("tám");
                        break;
                    case 9:
                        System.out.println("chín");
                        break;
                }
            }



        }



    }
}
