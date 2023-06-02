import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveProductShopRepository() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "диван", 3000);
        Product product2 = new Product(2, "кровать", 4000);
        Product product3 = new Product(3, "телевизор", 10_000);
        Product product4 = new Product(4, "шкаф", 6000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);
        shopRepository.remove(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotExistsProductShopRepository() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "диван", 3000);
        Product product2 = new Product(2, "кровать", 4000);
        Product product4 = new Product(4, "шкаф", 6000);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product4);


        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(3);

        });
    }


}
