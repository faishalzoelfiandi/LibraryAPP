package com.example.libapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Bookdata  {




    String judulbuku,penulisbuku,publisherbukku,halamanbuku,bukuid;

    public Bookdata(String judulbuku, String penulisbuku, String publisherbukku, String halamanbuku, String bukuid) {
        this.judulbuku = judulbuku;
        this.penulisbuku = penulisbuku;
        this.publisherbukku = publisherbukku;
        this.halamanbuku = halamanbuku;
        this.bukuid = bukuid;
    }

    public Bookdata() {
    }

    public String getJudulbuku() {
        return judulbuku;
    }

    public void setJudulbuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public String getPenulisbuku() {
        return penulisbuku;
    }

    public void setPenulisbuku(String penulisbuku) {
        this.penulisbuku = penulisbuku;
    }

    public String getPublisherbukku() {
        return publisherbukku;
    }

    public void setPublisherbukku(String publisherbukku) {
        this.publisherbukku = publisherbukku;
    }

    public String getHalamanbuku() {
        return halamanbuku;
    }

    public void setHalamanbuku(String halamanbuku) {
        this.halamanbuku = halamanbuku;
    }

    public String getBukuid() {
        return bukuid;
    }

    public void setBukuid(String bukuid) {
        this.bukuid = bukuid;
    }
}
