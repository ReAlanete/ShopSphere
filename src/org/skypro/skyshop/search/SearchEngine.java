package org.skypro.skyshop.search;

public class SearchEngine {


    private final Searchable[] searchables;
    private int size;


    public SearchEngine(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.searchables = new Searchable[capacity];
        this.size = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (int i = 0; i < size && count < 5; i++) {
            Searchable item = searchables[i];
            if (item != null && item.searchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count++] = item;
            }
        }
        return results;
    }

    public void add(Searchable item) {
        if (size >= searchables.length) {
            throw new IllegalStateException("SearchEngine is full");
        }
        searchables[size++] = item;
    }

    public static void printResults(Searchable[] results) {
        boolean found = false;

        for (int i = 0; i < results.length; i++) {
            if (results[i] != null) {
                System.out.println((i + 1) + ". " + results[i].getStringRepresentation());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ничего не найдено");
        }
    }
}
