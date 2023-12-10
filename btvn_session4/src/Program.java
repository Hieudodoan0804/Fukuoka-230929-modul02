import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5];
        Class cl = new Class();
        Student st = new Student();
//        st.input();
//        st.output();


        Student st1 = new Student("01","aa","bb",8,9,10);
        Student st2 = new Student("02","bb","cc",8,9,10);
        Student st3 = new Student("03","cc","dd",8,9,10);
        Student st4 = new Student("04","dd","ee",8,9,10);
        cl.add(st1);
        cl.add(st2);
        cl.add(st3);
        cl.add(st4);
        cl.edit(st1);
        cl.remove(st1);
        cl.show();


    }
}
