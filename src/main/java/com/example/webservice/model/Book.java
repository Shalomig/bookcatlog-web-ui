
package com.example.webservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Book {
    private Long id;
    private String name;
    private String isbn;
    private String publishDate;
    private Double price;
    private String bookType;

    // Constructor
    public Book() {}

    public Book(Long id, String name, String isbn, String publishDate, Double price, String bookType) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.price = price;
        this.bookType = bookType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    // Optional: Add toString() for easier debugging
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", price=" + price +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}




