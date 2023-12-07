import java.util.Arrays;

public class Store_class {
    private Product[] products;
    private int defaultElement = 10;
    private int index = 0;


    public Store_class(){
        this.products = new Product[defaultElement];
    }

    public boolean add(Product p){
        if (findId(p.getId())==null){
            if (index== products.length)
                products= Arrays.copyOf(products,products.length+defaultElement);
            products[index++]=p;
            return true;
        }
        return false;

    }
    //đếm số phần tử lưu trong kho(Store)
    public int size(){

        return index;
    }

    //xoá phần tử sản phẩm tại vị trí chỉ định
    //param index vị trí của phần tử cần xoá
    // return xoá thành công trả về true, ngược lại trả về false.
    public boolean remove (int index){
        if (index < 0 || index >= this.index) {
            System.out.println("Vị trí chỉ định không hợp lệ.");
            return false;
        }

        for (int i = index; i < this.index - 1; i++) {
            products[i] = products[i + 1];
        }

        products[this.index - 1] = null;
        this.index--;
        System.out.println("Sản phẩm tại index " + index + " đã được xóa.");
        return true;
    }

    public Product findId(String id){
        for (int i = 0; i < index; i++){
            if (products[i].getId().equals(id)){
                return products[i];
            }
        }
        return null;
    }

    public void sort(){
        for (int i = 0; i < index; i++){
            for (int j = i+1; j < index; j++) {
                if (products[i].getName().compareTo(products[j].getName())>0){
                    Product temp = products[i];
                    products[i]=products[j];
                    products[i]=temp;
                }
            }
        }
    }

    public  void  show(){
        for (int i = 0; i < index; i++){
            System.out.println(products[i].getId()+": "+products[i].getName());
        }
    }
}
