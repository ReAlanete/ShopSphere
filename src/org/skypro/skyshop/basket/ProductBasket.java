package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.*;


public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.add(product);
    }

    public int totalCostBasket() {
        int total = 0;
        for (Product product : products) {
            total += (int) product.getPrice();

        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Total cost basket: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProductInBasket(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        for (Product product : products) {
            if (name.equalsIgnoreCase(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        products.clear();
    }

    public List<Product> deletedByName(String name) {
        if (name == null || name.isBlank()) {
            return Collections.emptyList();
        }
        Iterator<Product> iterator = products.iterator();
        List<Product> deletedProducts = new ArrayList<>();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().trim().equalsIgnoreCase(name.trim())) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    @Override

    public String toString() {
        return "ProductBasket{" +
                "products=" + products +
                '}';
    }
}


