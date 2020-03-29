package ru.FogStreamBackEnd.FSBe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class AbstractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String url;

    public AbstractControllerTest(String url) {
        this.url = url + '/';
    }
}
