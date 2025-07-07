package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> searchables;


    public SearchEngine() {

        this.searchables = new LinkedList<>();
    }

    public Map<String,Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Query can't be null");
        }
        Map<String,Searchable> results = new TreeMap<>();
        if (query.isBlank()) {
            return results;
        }
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(searchable.getName(),searchable);
            }
        }
        return results;
    }

    public void printSearchablesInNewLine(Map<String,Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Cписок пуст");
            return;
        }
        for (Searchable searchable : results.values()) {
            System.out.println(searchable);
        }
    }

    public void add(Searchable item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null");
        }
        searchables.add(item);
    }


    public Searchable bestFoundMatch(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestMatch = null;
        search = search.toLowerCase();
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int currentCount = 0;
                String term = searchable.searchTerm().toLowerCase();
                int index = term.toLowerCase().indexOf(search);

                while (index != -1) {

                    currentCount++;
                    index = term.indexOf(search, index + search.length());
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
                "searchables=" + searchables +
                '}';
    }
}
