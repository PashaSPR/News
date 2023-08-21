package com.example.NewsFeed.Controllers;

import com.example.NewsFeed.Models.NewsPost;
import com.example.NewsFeed.Repo.NewsPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Controller
public class NewsController {
    @Autowired
    private NewsPostRepository repository;

    public NewsController(NewsPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/news")
    public String News( Model model) {
        Iterable<NewsPost> ICollectionNews=repository.findAll();
        ArrayList<NewsPost>  arrayListNews=new ArrayList<>();
        for (NewsPost item:ICollectionNews) {
            arrayListNews.add(item);
        }
        Collections.reverse(arrayListNews);
        model.addAttribute("News",arrayListNews);
        return "news";
    }
    @GetMapping("/news/addnews")
    public String AddNews( Model model) {
        return "addnews";
    }
    @PostMapping("/news/addnews")
    public String AddNewsPost(@RequestParam String title,@RequestParam String text, Model model) {
        NewsPost newsPost=new NewsPost(title,text);
        repository.save(newsPost);
        return "redirect:/news";
    }
    @GetMapping("/news/{id}")
    public String NewsById(@PathVariable(value = "id") long id, Model model) {

        if(repository.existsById(id)){
            NewsPost post=repository.findById(id).get();//отримання
            model.addAttribute("post",post);
            return "showNew";
        }
        return "redirect:/news";
    }
    @GetMapping("/news/{id}/update")
    public String Update(@PathVariable(value = "id") long id, Model model) {

        if(repository.existsById(id)){
            NewsPost post=repository.findById(id).get();
            model.addAttribute("news",post);
            return "updatenew";
        }
        return "redirect:/news";
    }

    @PostMapping("/news/{id}/update")
    public String UpdatePost(@PathVariable(value = "id") long id, @RequestParam String title,@RequestParam String text, Model model) {

        if(repository.existsById(id)){
            NewsPost post=repository.findById(id).get();
            post.setTitle();
            post.setText();
            post.setDate();
            return "updatenew";
        }
        return "redirect:/news";
    }
    @GetMapping("/news/{id}/delete")
    public String Delete(@PathVariable(value = "id") long id, Model model) {

        if(repository.existsById(id)){
            NewsPost post=repository.findById(id).get();
            repository.delete(post);
        }
        return "redirect:/news";
    }
    @GetMapping("/aboutUs")
    public String About(Model model) {

        return "aboutUs";
    }
}
