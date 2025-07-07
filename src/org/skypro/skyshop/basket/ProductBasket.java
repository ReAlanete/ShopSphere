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
        int total = 0;
        for (List<Product> productList : products.values()) {

            for (Product product : productList) {
                total += (int) product.getPrice();
            }
        }
        return total;
    }
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {

                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Total cost basket: " + totalCostBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean checkProductInBasket(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        for (List<Product> productList : products.values()) {

            for (Product product : productList) {
                if (name.equalsIgnoreCase(product.getName())) {
                    return true;
                }
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
        List<Product> deletedProducts = new ArrayList<>();
        for (List<Product> productList : products.values()) {

            Iterator<Product> iterator = productList.iterator();

            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().trim().equalsIgnoreCase(name.trim())) {
                    deletedProducts.add(product);
                    iterator.remove();
                }
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


