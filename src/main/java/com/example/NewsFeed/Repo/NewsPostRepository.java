package com.example.NewsFeed.Repo;

import com.example.NewsFeed.Models.NewsPost;
import org.springframework.data.repository.CrudRepository;

public interface NewsPostRepository extends CrudRepository<NewsPost,Long> {

}
