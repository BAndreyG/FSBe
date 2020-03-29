package ru.FogStreamBackEnd.FSBe.service;

import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.FogStreamBackEnd.FSBe.model.News;

import static org.junit.jupiter.api.Assertions.*;
import static ru.FogStreamBackEnd.FSBe.NewsTestData.NEWS_ID;

class NewsServiceTest {

    @Autowired
    private NewsService service;

    @Test
    void getAll() {
    }

    @Test
    void getId() {
        News actual=service.getId(NEWS_ID);
//        assert()
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.getId(1));
    }

    @Test
    void getNotOwn() throws Exception {
        assertThrows(NotFoundException.class, () ->
        {service.getId(NEWS_ID);});
    }
}