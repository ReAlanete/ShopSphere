package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

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
        System.out.println(basket.chekProductInBasket("Milk")); //Поиск товара, который есть в корзине
        System.out.println(basket.chekProductInBasket("Anti-Dandruff Shampoo 250ml")); //Поиск товара, которого нет в корзине
        System.out.println(basket.totalCostBasket());// Получение стоимости пустой корзины.
        System.out.println(basket.chekProductInBasket("Milk")); //Поиск товара по имени в пустой корзине.
        DiscountedProduct beer = new DiscountedProduct("Beer", 100, 20);
        FixPriceProduct bal = new FixPriceProduct("Bal");
        basket.addProduct(bal);
        basket.addProduct(beer);
        basket.addProduct(milk);


        Article article1 = new Article(
                "Java vs PHP: Производительность",
                "Java обычно превосходит PHP по скорости выполнения благодаря" +
                        " своей компиляции в байт-код и виртуальной машине."
        );

        Article article2 = new Article(
                "Java vs PHP: Простота изучения",
                "е" +
                        "синтаксической простоте, тогда как Java требует больше времени для освоения."
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
        SearchEngine search1 = null;
        try {
            search1 = new SearchEngine(10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (search1 != null) {
            search1.add(bal);
            search1.add(article5);
            search1.add(article4);
            search1.add(article3);
            search1.add(article2);
            search1.add(article1);
            search1.add(beer);
            search1.add(milk);

            System.out.println(Arrays.toString(search1.search("PHP")));
            System.out.println(Arrays.toString(search1.search("milk")));
            SearchEngine.printResults(search1.search("PHP"));
            SearchEngine.printResults(search1.search("milk"));
            SearchEngine.printResults(search1.search("wrhwrh"));

        }

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

        try {
            System.out.println(search1.bestFoundMatch("php"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }  try {
            System.out.println(search1.bestFoundMatch("rgwbww"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }


    }
}
