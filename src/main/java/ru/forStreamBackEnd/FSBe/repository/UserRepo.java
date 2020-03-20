package ru.forStreamBackEnd.FSBe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.forStreamBackEnd.FSBe.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
