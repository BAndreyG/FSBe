package ru.forStreamBackEnd.FSBe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forStreamBackEnd.FSBe.model.News;

@Repository
public interface NewsRepo extends JpaRepository<News,Integer> {
    News findById (int id);
}
