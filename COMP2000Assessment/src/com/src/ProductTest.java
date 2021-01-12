import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    public void ProductTest()
    {
        Product TestProduct = new Product();
        TestProduct.setID("3");
        TestProduct.setPrice(2.99);
        TestProduct.setName("Sweets");

        assertNotNull(TestProduct);
    }
}