import java.util.ArrayList;

import java.util.List;


public class CustomerBasket implements Discounts{
    public List<Product> productsInBasket;
    public double customerCount;

    public CustomerBasket(double customerCount) {
        this.productsInBasket = new ArrayList<>();
        this.customerCount = customerCount;
    }

    public List<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public double getCustomerCount() {
        if (this.customerCount >= 100){
            customerCount = this.customerCount / 100;
        }
        return customerCount;
    }

    public void setCustomerCount(double customerCount) {

        this.customerCount = customerCount;
    }

    public void setProductsInBasket(List<Product> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }


    @Override
    public void twoForThree() {
        double minPrice = Double.MAX_VALUE;


        for (Product product : getProductsInBasket()) {
            if (productsInBasket.size() == 3){
                customerCount += product.getPrice();
                if (minPrice > product.getPrice()){
                    minPrice = product.getPrice();
                }
            }

           else if (product.equals(getProductsInBasket().get(3))){
                for (int i = 0; i < 3; i++) {
                    productsInBasket.remove(0);
                }
                break;
            }else {
                customerCount += product.getPrice();
                if (minPrice > product.getPrice()){
                    minPrice = product.getPrice();
                }
            }

        }
        customerCount -= minPrice;
    }

    @Override
    public void secondProductHalfPrice() {
        List<Product> repeatedProducts = new ArrayList<>();
        for (Product product : productsInBasket) {
            int count = 0;
            for (Product product1 : productsInBasket) {
                if (product.getName().equals(product1.getName())){
                    count++;
                }
            }
            boolean isContains = false;
            for (Product repeatedProduct : repeatedProducts) {
                if (repeatedProduct.getName().equals(product.getName())){
                    isContains = true;
                }
            }
            if (count > 1 & !isContains){
                int countOfProducts = (int) Math.floor(count / 2);
                customerCount += count * (product.getPrice());
                int discount = 0;
                discount += (countOfProducts * (product.getPrice())) / 2;
                customerCount -= discount;
                repeatedProducts.add(product);

            }
            else if (!isContains){
                customerCount += product.getPrice();
            }
        }



    }
}
