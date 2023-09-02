package com.example.NewsFeed.Models;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class NewsPost {
    public NewsPost() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;

    private LocalDate date;

    private String text;
    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
    public NewsPost( String title, String text) {

        this.title = title;
        this.date = LocalDate.now();
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title=title;
    }

//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

    public void setDate() {
        this.date=LocalDate.now();
    }

    public void setText(String text) {
        this.text=text;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
