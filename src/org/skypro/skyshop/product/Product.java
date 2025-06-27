package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;
    public static final String TYPE_PRODUCT = "PRODUCT";

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be an empty string or null");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }


    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name;
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String getTypeContent() {
        return TYPE_PRODUCT;
    }
}