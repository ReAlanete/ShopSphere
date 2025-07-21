package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int totalCostBasket() {


        return products.values().stream().flatMap(Collection::stream).
                mapToInt(product -> (int) product.getPrice()).
                sum();
    }
    private int getSpecialCount() {
        return (int) products.values().stream().
                flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        products.values().stream()
                        .flatMap(Collection::stream)
                                .forEach(System.out::println);

        System.out.println("Total cost basket: " + totalCostBasket());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean checkProductInBasket(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return products.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> name.equalsIgnoreCase(product.getName()));
    }

    public void cleanBasket() {
        products.clear();
    }

    public List<Product> deletedByName(String name) {
        return products.remove(name);
    }

    @Override

    public String toString() {
        return "ProductBasket{" +
                "products=" + products +
                '}';
    }
}


