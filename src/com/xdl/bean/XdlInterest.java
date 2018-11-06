package com.xdl.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class XdlInterest implements Serializable {
    private int id;
    private int user_id;
    private int product_id;
    private Timestamp collect_time;
    private String bak;

    public XdlInterest() {
    }

    public XdlInterest(int id) {
        this.id = id;
    }

    public XdlInterest(int user_id, int product_id, String bak) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.bak = bak;
    }

    public XdlInterest(int user_id, int product_id) {
        this.user_id = user_id;
        this.product_id = product_id;
    }

    public XdlInterest(int id, int user_id, int product_id, Timestamp collect_time, String bak) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.collect_time = collect_time;
        this.bak = bak;
    }

    public XdlInterest(int user_id, int product_id, Timestamp collect_time, String bak) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.collect_time = collect_time;
        this.bak = bak;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Timestamp getCollect_time() {
        return collect_time;
    }

    public void setCollect_time(Timestamp collect_time) {
        this.collect_time = collect_time;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak;
    }

    @Override
    public String toString() {
        return "XdlInterest{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", collect_time=" + collect_time +
                ", bak='" + bak + '\'' +
                '}';
    }
}
