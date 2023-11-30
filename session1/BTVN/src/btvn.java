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
                    System.out.print("Một trăm"+" ");
                    break;
                case 2:
                    System.out.print("Hai trăm"+" ");
                    break;
                case 3:
                    System.out.print("Ba trăm"+" ");
                    break;
                case 4:
                    System.out.print("Bốn trăm"+" ");
                    break;
                case 5:
                    System.out.print("Năm trăm"+" ");
                    break;
                case 6:
                    System.out.print("Sáu trăm"+" ");
                    break;
                case 7:
                    System.out.print("Bảy trăm"+" ");
                    break;
                case 8:
                    System.out.print("Tám trăm"+" ");
                    break;
                case 9:
                    System.out.print("Chín trăm"+" ");
                    break;
            }if (tens%10==0&&units!=0) {
                System.out.print("lẻ"+" ");
            }
                switch (tens){
                    case 1:
                        System.out.print("mười"+" ");
                        break;
                    case 2:
                        System.out.print("hai mươi"+" ");
                        break;
                    case 3:
                        System.out.print("ba mươi"+" ");
                        break;
                    case 4:
                        System.out.print("bốn mươi"+" ");
                        break;
                    case 5:
                        System.out.print("năm mươi"+" ");
                        break;
                    case 6:
                        System.out.print("sáu mươi"+" ");
                        break;
                    case 7:
                        System.out.print("bảy mươi"+" ");
                        break;
                    case 8:
                        System.out.print("tám mươi"+" ");
                        break;
                    case 9:
                        System.out.print("chín mươi"+" ");
                        break;
                }
                switch (units){
                    case 1:
                        System.out.print("một");
                        break;
                    case 2:
                        System.out.print("hai");
                        break;
                    case 3:
                        System.out.print("ba");
                        break;
                    case 4:
                        System.out.print("bốn");
                        break;
                    case 5:
                        System.out.print("năm");
                        break;
                    case 6:
                        System.out.print("sáu");
                        break;
                    case 7:
                        System.out.print("bảy");
                        break;
                    case 8:
                        System.out.print("tám");
                        break;
                    case 9:
                        System.out.print("chín");
                        break;
                }

            }



        }



    }

