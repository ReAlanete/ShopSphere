package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXPRICE = 99;


    public FixPriceProduct(String name) {
        super(name);

    }

    @Override
    public double getPrice() {
        return FIXPRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXPRICE;
    }
}
