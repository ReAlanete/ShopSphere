package org.skypro.skyshop.search;


public class BestResultNotFound extends Exception {
    public BestResultNotFound(String s) {
    }

    @Override
    public String getMessage() {
        return "По вашему запросу ничего не найдено";
    }
}
