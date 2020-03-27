package ru.FogStreamBackEnd.FSBe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.FogStreamBackEnd.FSBe.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User getById(int id);

    User getByName(String name);
}
