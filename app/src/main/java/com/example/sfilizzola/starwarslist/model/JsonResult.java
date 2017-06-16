package com.example.sfilizzola.starwarslist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sfilizzola on 14/06/17.
 */

public class JsonResult {
    private int count;
    private String next;
    private String previous;
    private List<Character> results;

    public JsonResult(int count, String next, String previous, List<Character> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Character> getResults() {
        if (results == null) {
            return new ArrayList<>();
        } else {
            return results;
        }
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
