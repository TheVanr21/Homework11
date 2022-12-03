package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    Product[] products = new Product[0];

    public Product[] getAll() {
        return products;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Product[] tmp = new Product[products.length - 1];
            int indexForCopy = 0;
            for (Product product : products) {
                if (product.getId() != id) {
                    tmp[indexForCopy] = product;
                    indexForCopy++;
                }
            }
            products = tmp;
        } else {
            System.out.println("Продукт с ID: " + id + " не найден!");
        }
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void save(Product newProduct) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }
}
