package com.example.NewsFeed.Controllers;

import com.example.NewsFeed.Models.NewsPost;
import com.example.NewsFeed.Repo.NewsPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;

@Controller
public class MainController {
    @Autowired
    private NewsPostRepository repository;
//    @GetMapping("/")
//    public String greeting( Model model) {
//        model.addAttribute("name", "Pasha");
//        return "home";
//    }
    @GetMapping("/")
    public String Feed( Model model) {
        Iterable<NewsPost> ICollectionNews=repository.findAll();
        ArrayList<NewsPost> arrayListNews=new ArrayList<>();
        for (NewsPost item:ICollectionNews) {
            arrayListNews.add(item);
        }
        Collections.reverse(arrayListNews);
        model.addAttribute("News",arrayListNews);
        return "home";
    }
}
