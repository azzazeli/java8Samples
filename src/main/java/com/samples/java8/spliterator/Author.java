package com.samples.java8.spliterator;

import java.util.List;

/**
 * @author AlexM
 */
public class Author {
    private String name;
    private int relatedArticleId;

    public Author(String name, int relatedArticleId) {
        this.name = name;
        this.relatedArticleId = relatedArticleId;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", relatedArticleId=" + relatedArticleId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelatedArticleId() {
        return relatedArticleId;
    }

    public void setRelatedArticleId(int relatedArticleId) {
        this.relatedArticleId = relatedArticleId;
    }
}
