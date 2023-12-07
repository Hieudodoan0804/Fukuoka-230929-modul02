import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        /** Viết chương trình java. Nhập vào danh sách 5 sản phẩm.
         * Hiển thị thông tin sản phẩm theo giá bán (salePrice=price - (price / 100 * discount))
         * giảm dần.
         *
         * Yêu cầu BTVN: dựa trên class Product đã tạo, trong Product bổ sung phương thức calculateSalePrice() để
         * tính giá bán cho sản phẩm (salePrice = price - (price / 100 * discount)).
         * Viết chương trình Java thực hiện các chức năng sau:
         *      1. Nhập n sản phẩm (n nhập từ bàn phím, ko nhập priceOut)
         *      2. Tính giá bán (priceOut) cho từng sản phẩm vừa nhập
         *      3. Hiển thị danh sách sản phẩm theo giá bán (salePrice) tăng dần
         *      4. Thoát
         * Để thực hiện chức năng, người dùng sẽ nhập 1 số nguyên x tương ứng chức năng ở trên.
         * Chương trình sẽ thực hiện lặp lại cho đến khi người dùng chọn chức năng 4. Thoát
         */

        /*
        *Product {
	String id;
	String name;
	double price;
	double discount;
	double slaePrice;

	Product() {} // constructor ko tham số
	Product(id, name, price, discount) {} // constructor có tham số
	// Get/Set
	calculateSalePrice() {} // Tính giá bán cho sản phẩm
}
Dựa trên class Product trong BTVN buổi trước, phát triển tiếp ứng dụng
Tạo class Store {
	Product[] products;

	void add(Product p) {} // Thêm sản phẩm vào mảng products
	Product findId(String id) {} // Tìm kiếm sản phẩm trong mảng products
	boolean sort() {} // Sắp xếp các sản phẩm trong mảng products theo tên từ A-Z
	void show() {} // Hiển thị toàn bộ dữ liệu sản phẩm đã được thêm trong mảng products
}
Viết chương trình Java kiểm tra các phương thức của class Sotre
        *
        * */

/*
        Scanner scanner = new Scanner(System.in);
        int functionList;
        int n=0;
        Product[] products = new Product[5];
        do {
            System.out.println("Nhập chức năng để chạy chương trình");
            System.out.println("1.Nhập thông tin sản phẩm");
            System.out.println("2.Tính giá sản phẩm");
            System.out.println("3.Hiển thị danh sách sản phẩm");
            System.out.println("4.Thoát chương trình");
            functionList = scanner.nextInt();
            scanner.nextLine();
            switch (functionList){
                case 1:
                    System.out.println("Nhập n sản phẩm");
                    n = scanner.nextInt();
                    scanner.nextLine();
                    //nhap lieu
                    for (int i = 0; i < n; i++){
                        System.out.println("Hãy nhập thông tin cho sản phẩm thứ "+(i+1)+":");
                        Product p = new Product();
                        System.out.println("Mã sp: ");
                        p.setId(scanner.nextLine());
                        System.out.println("Tên sp: ");
                        p.setName(scanner.nextLine());
                        System.out.println("Giá sp: ");
                        p.setPrice(Double.parseDouble(scanner.nextLine()));
                        System.out.println("Giảm giá(%): ");
                        p.setDiscount(Double.parseDouble(scanner.nextLine()));
                        products[i] = p;
                    }
                    break;
                case 2:
                    //tinh gia ban
                    for (int i = 0; i < n; i++){
                        products[i].setSalePrice(products[i].getPrice()-(products[i].getPrice()/100*products[i].getDiscount()));
                    }
                    break;
                case 3:
                    //sap xep
                    for (int i = 0; i < n; i++){
                        for (int j = i+1;j < n; j++){
                            if (Double.compare(products[i].getSalePrice(),products[j].getSalePrice())>0){
                                Product temp = products[i];
                                products[i]=products[j];
                                products[j]=temp;
                            }
                        }
                    }
                    //hien thi
                    for (int i = 0; i < n; i++){
                        System.out.println("ID:"+products[i].getId());
                        System.out.println("Name:"+products[i].getName());
                        System.out.println("SalePrice:"+products[i].getSalePrice());
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình");
                    break;
            }
        }while (functionList!=4);
*/


        Store_class store = new Store_class();
        Product p1 = new Product("P01", "A phẩm 1", 1000, 10);
        Product p2 = new Product("P02", "C phẩm 2", 1000, 10);
        Product p3 = new Product("P03", "D phẩm 3", 1000, 10);
        Product p4 = new Product("P04", "B phẩm 4", 1000, 10);
        Product p5 = new Product("P05", "F phẩm 5", 1000, 10);

        Product p6 = new Product("P06", "H phẩm 6", 1000, 10);
        Product p7 = new Product("P07", "W phẩm 7", 1000, 10);
        Product p8 = new Product("P08", "E phẩm 8", 1000, 10);
        Product p9 = new Product("P09", "R phẩm 9", 1000, 10);
        Product p10 = new Product("P10", "Z phẩm 10", 1000, 10);
        Product p11 = new Product("P11", "O phẩm 11", 1000, 10);
        store.add(p1);
        store.add(p2);
        store.add(p3);
        store.add(p4);
        store.add(p5);
        store.add(p6);
        store.add(p7);
        store.add(p8);
        store.add(p9);
        store.add(p10);
        store.add(p11);
        store.show();
        store.sort();
        store.show();

    }
}
