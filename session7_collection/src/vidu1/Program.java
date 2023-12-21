package vidu1;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        /*
        * cho class Student sau:
        * Students
        * id: int;
        * firstname: String
        * lastName: String
        * gender:boolean
        * viết chương trình java cho phép
        * nhập danh sách 5 sinh viên từ bàn phím (sử dụng Lít)
        * hiển thị danh sách sinh viên theo nhóm Họ
        * */
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        for (int i = 0; i<5;i++){
            Student st = new Student();
            System.out.println("Nhập thông tin sinh viên thứ: "+ (i+1));
            System.out.println("ID: ");
            st.setId(Integer.parseInt(scanner.nextLine()));
            System.out.println("Firstname: ");
            st.setFirstName(scanner.nextLine());
            System.out.println("Lastname: ");
            st.setLastName(scanner.nextLine());
            System.out.println("Gender: ");
            st.setGender(Boolean.parseBoolean(scanner.nextLine()));
            students.add(st);
        }

        // dung Set

  /*      Set<String> firstName = new HashSet<>();
        students.forEach(x->firstName.add(x.getFirstName()));
        firstName.forEach(x->{
            System.out.println(x);
            students.forEach(sv->{
                if (sv.getFirstName().equals(x))
                    System.out.println("\t"+sv.getFirstName()+" "+sv.getLastName()+" | Gender: "+(sv.isGender()?"Nam":"Nữ"));
            });
        });*/

        // dung Map
        Map<String,List<Student>> data = new HashMap<>();
        for (Student student : students){
            String lastName = student.getLastName();
            if (!data.containsKey(lastName)){
                data.put(lastName,new ArrayList<>());
            }
            data.get(lastName).add(student);
        }
       for (Map.Entry<String,List<Student>> entry : data.entrySet()){
           System.out.println(entry.getKey());
           for (Student student : entry.getValue()){
               System.out.println("\t " + student.getLastName() + " " + student.firstName +" | Gender: "+(student.isGender()?"Nam":"Nữ") );
           }
       }


    }


}
