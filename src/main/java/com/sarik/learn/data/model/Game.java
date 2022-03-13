package com.sarik.learn.data.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private String detail;
    private Integer price;
    private Double rating;
    private List<String> dlc = new ArrayList<>();

    public Game(){

    }

    public Game(String name){
        this.name = name;
    }

    public Game(String name, Integer price, String detail, Double rating) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.rating = rating;
    }

    public Game(String name, Integer price, String detail, Double rating, List<String> dlc) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.rating = rating;
        this.dlc = dlc;
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

    public void printAllDetail(){
        System.out.println(this.name + " " + this.detail);
    }

    public List<String> getDlc() {
        return dlc;
    }

    public void setDlc(List<String> dlc) {
        this.dlc = dlc;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", dlc=" + dlc +
                '}';
    }
}
