package ru.forStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.forStreamBackEnd.FSBe.model.News;
import ru.forStreamBackEnd.FSBe.repository.NewsRepo;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepo newsRepo;

    public NewsService(NewsRepo newsRepo){this.newsRepo=newsRepo;}

    public List<News> getAll(){
        return newsRepo.findAll(Sort.by("createday"));
    }

    public News getId(int id){return newsRepo.findById(id);}
}
