package ru.FogStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.FogStreamBackEnd.FSBe.model.News;
import ru.FogStreamBackEnd.FSBe.repository.NewsRepo;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepo repo;

    public NewsService(NewsRepo repo){this.repo=repo;}

    public List<News> getAll(){
        return repo.findAll(Sort.by("createday"));
    }

    public News getId(int id){return repo.findById(id);}
}
