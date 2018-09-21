package com.samples.java8.spliterator;

import java.util.List;

/**
 * @author AlexM
 */
public class Article {
    private int id;
    private String name;
    private List<Author> listOfAuthors;

    public Article(String name) {
        this.name = name;
    }

    public Article(List<Author> listOfAuthors, int id) {
        this.id = id;
        this.listOfAuthors = listOfAuthors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getListOfAuthors() {
        return listOfAuthors;
    }

    public void setListOfAuthors(List<Author> listOfAuthors) {
        this.listOfAuthors = listOfAuthors;
    }
}
