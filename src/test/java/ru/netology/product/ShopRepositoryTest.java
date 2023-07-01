package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Товар", 100);
        repository.add(product);

        repository.removeById(1);

        Product[] allProducts = repository.findAll();
        Assertions.assertEquals(0, allProducts.length);
    }

    @Test
    public void shouldThrowNotFoundExceptionForNonExistingProduct() {
        ShopRepository repository = new ShopRepository();

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(1));
    }
}
