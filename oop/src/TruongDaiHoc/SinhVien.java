public class SinhVien {
    //thuộc tính (giống với biến)
    private String hoTen;
    private double diem;

    // constructor mặc định
    public SinhVien() {
        hoTen = "No name";
        diem = 0.8;
    }

    // constructor có đối số


    public SinhVien(String hoTen) {
        this.hoTen = hoTen;
    }

    public SinhVien(String hoTen, double diem) {
        this.hoTen = hoTen;
        this.diem = diem;
    }

    //phương thức(các hàm)
    // phương thức k có kiểu trả về
    public void hienThiThongTin(){
        System.out.println(hoTen+" : "+ diem);
    }

}
