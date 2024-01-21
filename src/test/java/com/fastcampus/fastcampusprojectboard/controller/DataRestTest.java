package com.fastcampus.fastcampusprojectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("DataRest - API 테스트")
@Transactional // rollback을 위해 필요
@AutoConfigureMockMvc // MockMvc를 사용하기 위해 필요
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class DataRestTest {

    private MockMvc mockMvc;

    public DataRestTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("[api] 게시글 리스트 조회 테스트")
    void DataRestTest() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    @Test
    @DisplayName("[api] 게시글 단건 조회 테스트")
    void DataRestTest2() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    @Test
    @DisplayName("[api] 게시글 댓글 리스트 조회 테스트")
    void DataRestTest3() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    @Test
    @DisplayName("[api] 댓글 리스트 조회 테스트")
    void DataRestTest4() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }

    @Test
    @DisplayName("[api] 댓글 단건 조회 테스트")
    void DataRestTest5() throws Exception {
        // given

        // when

        // then
        mockMvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/hal+json"));
    }


}
