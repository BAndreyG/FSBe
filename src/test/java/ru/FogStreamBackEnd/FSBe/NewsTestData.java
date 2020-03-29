package ru.FogStreamBackEnd.FSBe;

import ru.FogStreamBackEnd.FSBe.model.News;

import java.time.LocalDateTime;

import static ru.FogStreamBackEnd.FSBe.CategoryTestData.CATEGORY1;
import static ru.FogStreamBackEnd.FSBe.model.AbstractBaseEntity.START_SEQ;

public class NewsTestData {
    public static final int NEWS_ID = START_SEQ + 6;
    public static final News NEWS=new News(NEWS_ID,"head","mintext","news","preview", LocalDateTime.now(),"link",true,CATEGORY1);
}
