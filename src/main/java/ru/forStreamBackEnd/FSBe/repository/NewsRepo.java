package ru.forStreamBackEnd.FSBe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forStreamBackEnd.FSBe.model.News;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News,Integer> {
    News findById (int id);
//    List<News> getAll();
}
