package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product milk = new Product("Milk", 95);
        Product chickenMeat = new Product("Chicken Meat", 355);
        Product eggs = new Product("Eggs (10 pcs)", 120);
        Product rice = new Product("Basmati Rice 1kg", 150);
        Product chocolate = new Product("Dark Chocolate 100g", 85);
        Product shampoo = new Product("Anti-Dandruff Shampoo 250ml", 220);
        basket.addProduct(milk);
        basket.addProduct(chickenMeat);
        basket.addProduct(eggs);
        basket.addProduct(rice);
        basket.addProduct(chocolate);  // Добавление продукта в корзину.
        basket.addProduct(shampoo); // Добавление в заполненную корзину, в которой нет места.
        basket.printBasket(); // Печать содержимого корзины с несколькими товарами.
        System.out.println(basket.totalCostBasket()); // Получение стоимости корзины с несколькими товарами.
        System.out.println(basket.chekProductInBasket("Milk")); //Поиск товара, который есть в корзине
        System.out.println(basket.chekProductInBasket("Anti-Dandruff Shampoo 250ml")); //Поиск товара, которого нет в корзине
        basket.cleanBasket(); //Очистка корзины
        basket.printBasket(); //Печать содержимого пустой корзины.
        System.out.println(basket.totalCostBasket());// Получение стоимости пустой корзины.
        System.out.println(basket.chekProductInBasket("Milk")); //Поиск товара по имени в пустой корзине.
    }

}
