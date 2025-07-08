package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

import java.util.List;

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
        System.out.println(basket.totalCostBasket()); // Получение стоимости корзины с несколькими товарами.
        System.out.println(basket.checkProductInBasket("Milk")); //Поиск товара, который есть в корзине
        basket.cleanBasket();
        System.out.println(basket.totalCostBasket());// Получение стоимости пустой корзины.
        System.out.println(basket.checkProductInBasket("Milk")); //Поиск товара по имени в пустой корзине.
        DiscountedProduct beer = new DiscountedProduct("Beer", 100, 20);
        FixPriceProduct ball = new FixPriceProduct("Ball");
        basket.addProduct(ball);
        basket.addProduct(beer);
        basket.addProduct(milk);
        basket.printBasket();
        Article article1 = new Article(
                "Java vs PHP: Производительность",
                "Java обычно превосходит PHP по скорости выполнения благодаря" +
                        " своей компиляции в байт-код и виртуальной машине."
        );

        Article article2 = new Article(
                "Java vs PHP: Простота изучения",
                "PHP проще для изучения благодаря синтаксической простоте, тогда как Java требует больше времени для освоения."
        );

        Article article3 = new Article(
                "Java vs PHP: Использование в веб-разработке",
                "PHP широко используется для серверной части веб-приложений," +
                        " а Java — для крупных корпоративных систем и приложений с высокой нагрузкой."
        );

        Article article4 = new Article(
                "Java vs PHP: Безопасность",
                "Java предлагает встроенные механизмы безопасности," +
                        " что делает её предпочтительным выбором для приложений, требующих высокого уровня защиты." +
                        " PHP также имеет средства безопасности, но требует более тщательной настройки."
        );

        Article article5 = new Article(
                "Java vs PHP: Сообщество и поддержка",
                "Оба языка имеют большое сообщество разработчиков. " +
                        "Java широко используется в корпоративных решениях, а PHP — в веб-разработке с множеством" +
                        " фреймворков и CMS."
        );


        SearchEngine search1 = new SearchEngine();


        search1.add(ball);
        search1.add(article5);
        search1.add(article4);
        search1.add(article3);
        search1.add(article2);
        search1.add(article1);
        search1.add(beer);
        search1.add(beer);
        search1.add(beer);
        search1.add(beer);
        search1.add(milk);


        try {
            SimpleProduct apple = new SimpleProduct("apple", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct carrot = new DiscountedProduct("Carrot", 250, -1);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            FixPriceProduct anotherProduct = new FixPriceProduct(" ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------- Реализация метода bestFoundMatch --------------");
        try {
            System.out.println(search1.bestFoundMatch("php"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(search1.bestFoundMatch("rgwbww"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(search1.bestFoundMatch("milk"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        basket.addProduct(beer);
        basket.addProduct(beer);
        basket.addProduct(beer);
        basket.addProduct(beer);
        basket.addProduct(beer);
        System.out.println("----------------- Печать корзины до удаления ----------------");
        basket.printBasket();
        System.out.println("----------------- Реализация метода search ----------------");
        System.out.println(search1.search("ee"));
        search1.printSearchablesInNewLine(search1.search("php"));
        System.out.println("--------------- Реализация метода deletedByName ---------------");
        System.out.println(basket.deletedByName("Beer"));
        System.out.println("----------------- Печать корзины после удаления ----------------");
        basket.printBasket();
        System.out.println("----------------- Поиск продукта которого нет ----------------");
        List<Product> deletedProducts = basket.deletedByName("продукт которого нет");
        if (deletedProducts == null) {
            System.out.println("Список пуст");
        } else {
            System.out.println(deletedProducts);
        }

    }
}
