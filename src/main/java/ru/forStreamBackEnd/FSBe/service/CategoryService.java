package ru.forStreamBackEnd.FSBe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.forStreamBackEnd.FSBe.model.Category;
import ru.forStreamBackEnd.FSBe.repository.CategoryRepo;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo repo;

    public CategoryService (CategoryRepo repo){this.repo=repo;}

    public List<Category> getAll(){return repo.findAll(Sort.by("name"));}
}
