import java.util.Arrays;

public class Class {
    private Student[] students;
    private final int defaultElement = 10;
    private int index = 0;

    public Class(){
        this.students = new Student[defaultElement];
    }

    // add học viên
    public boolean add(Student st){
        // kiểm tra xem trong mang đã có id đó chưa (=null là chưa có id thì add)
        if (findId(st.getId()) == null){
            if (index == students.length){
                students = Arrays.copyOf(students,students.length + defaultElement);
            }
            students[index++] = st;
            return true;
        }
        return false;
    }

    // Cập nhật thông tin học viên
    public boolean edit(Student st){
        Student editStudent = findId(st.getId());
        if (editStudent != null){
            editStudent.setFirstName(st.getFirstName());
            editStudent.setLastName(st.getLastName());
            editStudent.setMarkCss(st.getMarkCss());
            editStudent.setMarkJs(st.getMarkJs());
            editStudent.setMarkHtml(st.getMarkHtml());
            return true;
        }
        return false;
    }

    // Xoá học viên khỏi lớp
    public boolean remove(Student st){
        if (st==null){
            return false;
        }else {
            Student[] newStudent = new Student[index-1];
            for (int i = 0, j = 0; i < index; i++){
                if (i == (index-1)){
                    continue;
                }
                newStudent[j++] = students[i];
            }
            index--;
            students = newStudent;
            return true;
        }
    }

    public int findIndex(String id){
        for (int i = 0; i < index; i++){
            if (students[i].getId().equals(id)){
                return i+1;
            }
        }
        return 0;
    }
    public Student findId(String id){
        for (int i = 0; i < index; i++){
            if (students[i].getId().equals(id)){
                return students[i];
            }
        }
        return null;
    }

    public void show(){
        for (int i = 0; i < index; i++){
            System.out.println(students[i].getId() + ": " + students[i].getFirstName()+students[i].getLastName());
        }
    }
}
