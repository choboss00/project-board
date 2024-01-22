package com.fastcampus.fastcampusprojectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(controllers = ArticleController.class) // 해당 컨트롤러와 관련된 Bean들만 등록해줌으로써, 이 컨트롤러만 테스트 가능
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Test
    @DisplayName("[view] [GET] 게시글 리스트 페이지 - 정상 호출")
    void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {
        // given

        // when

        // then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));

    }

    @Test
    @DisplayName("[view] [GET] 게시글 상세 페이지 - 정상 호출")
    void givenNothing_whenRequestingArticlesView_thenReturnsArticlesViewDetails() throws Exception {
        // given

        // when

        // then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));

    }

    @Test
    @DisplayName("[view] [GET] 게시글 검색 전용 페이지 - 정상 호출")
    void givenNothing_whenRequestingArticlesSearchView_thenReturnsArticlesSearchView() throws Exception {
        // given

        // when

        // then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));

    }

    @Test
    @DisplayName("[view] [GET] 게시글 해시태그 전용 검색 페이지 - 정상 호출")
    void givenNothing_whenRequestingArticlesHashtagSearchView_thenReturnsArticlesHashtagSearchView() throws Exception {
        // given

        // when

        // then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));

    }


}
