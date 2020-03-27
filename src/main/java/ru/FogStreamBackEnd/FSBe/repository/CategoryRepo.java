package ru.FogStreamBackEnd.FSBe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.FogStreamBackEnd.FSBe.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByName(String name);
}
