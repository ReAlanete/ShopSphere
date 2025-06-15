package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int percent;


    public DiscountedProduct(String name, int price, int percent) {
        super(name);
        this.basePrice = price;
        this.percent = percent;

    }


    @Override
    public double getPrice() {
        return basePrice * (1 - percent / 100.0);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basePrice == that.basePrice && percent == that.percent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, percent);
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + percent + "%)";
    }
}
