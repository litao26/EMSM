package com.xdl.bean;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class XdlCartItem implements Serializable {
    private  int product_id;
    private String picture;
    private String name;
    private double lower_price;
    private  double backMoney;
    private  int score;
    private  int count;

    public XdlCartItem() {
    }

    public XdlCartItem(String picture, String name, double lower_price, double backMoney, int score, int count) {
        this.picture = picture;
        this.name = name;
        this.lower_price = lower_price;
        this.backMoney = backMoney;
        this.score = score;
        this.count = count;
    }

    public XdlCartItem(int product_id, String picture, String name, double lower_price, double backMoney, int score, int count) {
        this.product_id = product_id;
        this.picture = picture;
        this.name = name;
        this.lower_price = lower_price;
        this.backMoney = backMoney;
        this.score = score;
        this.count = count;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLower_price() {
        return lower_price;
    }

    public void setLower_price(double lower_price) {
        this.lower_price = lower_price;
    }

    public double getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(double backMoney) {
        this.backMoney = backMoney;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XdlCartItem that = (XdlCartItem) o;
        return product_id == that.product_id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(product_id);
    }

    @Override
    public String toString() {
        return "XdlCartItem{" +
                "product_id=" + product_id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", lower_price=" + lower_price +
                ", backMoney=" + backMoney +
                ", score=" + score +
                ", count=" + count +
                '}';
    }
}
