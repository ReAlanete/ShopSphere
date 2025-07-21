package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> searchables;


    public SearchEngine() {

        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String query) {
        if (query == null) {
            throw new IllegalArgumentException("Query can't be null");
        }
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        if (query.isBlank()) {
            return results;
        }

        return searchables.stream().
                filter(searchable -> {
                    String term = searchable.searchTerm();
                    return term != null && term.toLowerCase().contains(query.toLowerCase());
                }).collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public void printSearchablesInNewLine(Set<Searchable> results) {
        if (results == null) {
            System.out.println("Error: Search results are null");
            return;
        }

        if (results.isEmpty()) {
            System.out.println("No results found");
            return;
        }

        int counter = 1;
        for (Searchable searchable : results) {
            System.out.println(counter++ + ". " + searchable);
        }

        System.out.println("Total found: " + results.size());
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
