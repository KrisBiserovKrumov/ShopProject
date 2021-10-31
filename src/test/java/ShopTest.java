import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ShopTest {

    private Shop shop;
    private Product product1;
    private Product product2;

    @Before
        public void before() {

            this.product1 = new Product("apple", 60);
            this.product2 = new Product("peach" , 80);

            this.shop = new Shop();
        }


         @Test
         public void addProductShouldWorkCorrectly() {
             shop.getProducts().add(product1);
             Assert.assertEquals(1, shop.getProducts().size());


         }

        @Test(expected = IllegalArgumentException.class)
        public void addProductShouldThrowIfExist() {
            shop.getProducts().add(product1);
            shop.getProducts().add(product1);
        }


        @Test
        public void removeProductShouldWork() {
            this.shop.getProducts().add(product1);
            this.shop.getProducts().add(product2);
            this.shop.getProducts().remove(product1);
            Assert.assertEquals(1, shop.getProducts().size());

        }

    }
