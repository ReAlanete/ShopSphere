package org.skypro.skyshop.search;


import java.util.Arrays;

public class SearchEngine {

    private static final int MAX_RESULTS = 5;
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
        Searchable[] results = new Searchable[MAX_RESULTS];
        int count = 0;
        for (int i = 0; i < size && count < results.length; i++) {
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

    public Searchable bestFoundMatch(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestMatch = null;
        search = search.toLowerCase();
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int currentCount = 0;
                String term = searchable.searchTerm().toLowerCase();
                int index = term.indexOf(search);

                while (index != -1) {

                    currentCount++;
                    index = term.toLowerCase().indexOf(search, index + search.length());
                }


                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    bestMatch = searchable;
                }
            }


        }
        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;

    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + Arrays.toString(searchables) +
                ", size=" + size +
                '}';
    }
}
