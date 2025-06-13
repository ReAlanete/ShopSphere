package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;


public class ProductBasket {
    private final Product[] products;
    private int counter;

    public ProductBasket() {
        this.products = new Product[5];
        this.counter = 0;
    }

    public void addProduct(Product product) {
        if (counter < products.length) {
            products[counter] = product;
            counter++;
        } else {
            System.out.println("В корзине нет места");
        }
    }

    public int totalCostBasket() {
        int total = 0;
        for (int i = 0; i < counter; i++) {
            if (products[i] != null) {  // Защита от null
                total += products[i].getCost();
            }
        }
        return total;
    }

    public void printBasket() {
        if (counter == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        for (int i = 0; i < counter; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getCost());
        }
        System.out.println("Total cost basket: " + totalCostBasket());
    }

    public boolean chekProductInBasket(String name) {

        for (int i = 0; i < counter; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
            counter = 0;
        }
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + Arrays.toString(products) +
                ", counter=" + counter +
                '}';
    }
}


