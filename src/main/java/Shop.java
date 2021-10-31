import java.util.ArrayList;
import java.util.List;

public class Shop {
    public List<Product> products;




    public Shop() {
        this.products = new ArrayList<>();
    }



    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
