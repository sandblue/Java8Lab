package com.sarik.learn.data.model;

public class Game {

    private String name;
    private String detail;
    private Integer price;
    private Double rating;

    public Game(String name, Integer price, String detail, Double rating) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
