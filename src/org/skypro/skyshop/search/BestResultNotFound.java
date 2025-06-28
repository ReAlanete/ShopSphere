package org.skypro.skyshop.search;


public class BestResultNotFound extends Exception {
    public BestResultNotFound(String s) {
        super("No matching result for: " + s);
    }
}
