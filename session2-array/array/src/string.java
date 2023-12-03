import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class string {
    public static void main(String[] args) {
        /*Viết chương trình java, Nhập thông tin người dùng từ bàn phím gồm: Tên, SĐT, Email.
        Yêu cầu SĐT đúng định dạng SĐT Việt Nam, Email đúng định dạng email.
        Nếu nhập sai yêu cầu nhập lại. Hiển thị lại thông tin vừa nhập*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập SDT");
        String phone = sc.nextLine();
        System.out.println("Nhập Email");
        String email = sc.nextLine();
        class EmailExamle{
            private  static Pattern pattern;
            private Matcher matcher;
            private static final String EMAIL_REGEX ="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)$";
            public EmailExamle(){
                pattern =Pattern.compile((EMAIL_REGEX));
            }
            public boolean validate(String regex){
                matcher=pattern.matcher(regex);
                return matcher.matches();
            }
            }
        }

    }
