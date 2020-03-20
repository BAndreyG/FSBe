package ru.forStreamBackEnd.FSBe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forStreamBackEnd.FSBe.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
