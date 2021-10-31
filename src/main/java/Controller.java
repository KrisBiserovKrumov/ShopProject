import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Controller {
    public static void main(String[] args) throws IOException {
        System.out.println("Please write your groceries: ");
        System.out.println("Example; apple 20 ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Shop shop = new Shop();
        CustomerBasket customerBasket = new CustomerBasket(0);

        String input = reader.readLine();

        while (!input.contains(",")){
            String[] productPrice = input.split(" ");
            Product product = new Product(productPrice[0],Double.parseDouble(productPrice[1]));
            shop.products.add(product);
            input = reader.readLine();
        }
        String[] basket = input.split(",");
        for (String basketProduct : basket) {
            for (Product product : shop.getProducts()) {
                if (basketProduct.equals(product.getName())){
                    Product newProduct = new Product(product.getName(),product.getPrice());
                    customerBasket.productsInBasket.add(newProduct);

                }
            }
        }


        customerBasket.twoForThree();
        customerBasket.secondProductHalfPrice();




        System.out.println("Customer count is " + customerBasket.getCustomerCount() + " aws");
    }
}
