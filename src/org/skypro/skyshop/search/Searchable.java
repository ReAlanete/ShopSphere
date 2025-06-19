package org.skypro.skyshop.search;

public interface Searchable {
    String searchTerm();

    String getName();

    String getTypeContent();

    default String getStringRepresentation() {
        return getName() + " " + getTypeContent();
    }

}
