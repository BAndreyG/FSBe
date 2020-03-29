package ru.FogStreamBackEnd.FSBe;

import ru.FogStreamBackEnd.FSBe.model.Category;

import static ru.FogStreamBackEnd.FSBe.model.AbstractBaseEntity.START_SEQ;

public class CategoryTestData {

    public static final int CATEGORY_ID = START_SEQ + 2;
    public static final Category CATEGORY1=new Category(CATEGORY_ID,"testCategory");
}
