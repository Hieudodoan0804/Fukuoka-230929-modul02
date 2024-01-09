import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // Sử dụng Stream API, lambda expression
        // 1. Hiển ra danh sách các sp Model bắt đầu bằng "M"
        // 2. Tìm kiếm sản phẩm theo Model (Model là duy nhất trong collection)
        // 3. Lấy ra danh sách List<String> model sản phẩm
        // 4. Kiểm tra xem trong collection có bất kỳ sản phẩm nào giá > 1000 không?
        // 5. Đếm các sản phẩm có cùng mức giá
        // VD: 1000: 2 sp
        //     2000: 3 sp
        //     3000: 1 sp
        List<Product> data = new ArrayList<>();
        Product product = new Product("00","AA00","SP1",1000,false);
        Product product1 = new Product("01","AM01","SP2",2000,true);
        Product product2 = new Product("02","MA02","SP3",5000,false);
        Product product3 = new Product("03","ABM03","SP4",15000,true);
        data.add(product);
        data.add(product1);
        data.add(product2);
        data.add(product3);
        // 1. Hiển ra danh sách các sp Model bắt đầu bằng "M"
        List<Product> modelShow = data.stream()
                .filter(p -> p.getModel().startsWith("M"))
                .collect(Collectors.toList());
        System.out.println("1.Sản phẩm Model bắt đầu bằng M : " + modelShow);
        // 2. Tìm kiếm sản phẩm theo Model (Model là duy nhất trong collection)
        Map<String,Product> findModel = data.stream()
                .collect(Collectors.toMap(Product::getModel,p -> p,(existing,replacement)->existing));
        System.out.println("2.Sản phẩm theo model:"+ findModel);
        // 3. Lấy ra danh sách List<String> model sản phẩm
        List<String> modelList = data.stream()
                .map(Product::getModel)
                .collect(Collectors.toList());
        System.out.println("3.Danh sách các model:" + modelList);
        // 4. Kiểm tra xem trong collection có bất kỳ sản phẩm nào giá > 1000 không?
        boolean checkPrice = data.stream()
                .anyMatch(p -> p.getPrice()>1000);
        System.out.println("4.Có sản phẩm nào giá > 1000 không?" + checkPrice);
        // 5. Đếm các sản phẩm có cùng mức giá
        Map<Double,Long> countByPrice = data.stream()
                .collect(Collectors.groupingBy(Product::getPrice,Collectors.counting()));
        
    }

}
