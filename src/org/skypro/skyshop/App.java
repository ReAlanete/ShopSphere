package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        SimpleProduct milk = new SimpleProduct("Milk", 95);
        SimpleProduct chickenMeat = new SimpleProduct("Chicken Meat", 355);
        SimpleProduct eggs = new SimpleProduct("Eggs (10 pcs)", 120);
        SimpleProduct rice = new SimpleProduct("Basmati Rice 1kg", 150);
        SimpleProduct chocolate = new SimpleProduct("Dark Chocolate 100g", 85);
        SimpleProduct shampoo = new SimpleProduct("Anti-Dandruff Shampoo 250ml", 220);
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
        DiscountedProduct beer = new DiscountedProduct("Beer", 100, 20);
        FixPriceProduct bal = new FixPriceProduct("Bal");
        basket.addProduct(bal);
        basket.addProduct(beer);
        basket.addProduct(milk);
        basket.printBasket();
        eggs.setPrice(100);
        System.out.println(eggs.getPrice());
    }

}
