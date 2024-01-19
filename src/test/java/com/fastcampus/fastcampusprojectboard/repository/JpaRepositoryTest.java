package com.fastcampus.fastcampusprojectboard.repository;

import com.fastcampus.fastcampusprojectboard.config.JpaConfig;
import com.fastcampus.fastcampusprojectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("testdb")
@DisplayName("JPA 연결 테스트")
@DataJpaTest // 이 어노테이션이 자동으로 테스트 db 를 띄워버림. 그래서 내가 설정한 db 로 테스트하기 위해선 추가 설정을 해줘야 함
@Import(JpaConfig.class) // auditing 을 위해 import
class JpaRepositoryTest {

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Test
    @DisplayName("select Test")
    void givenTestData_whenSelecting_thenWorksFine() {
        // given

        // when
        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(articles)
                .isNotNull()
                .hasSize(8);
    }
    
    @Test
    @DisplayName("insert Test")
    void insertTest() {
        // given
        long prevCount = articleRepository.count();
        Article article = Article.of("title", "content", "#spring");
        // when
        articleRepository.save(article);
        
        // then
        assertThat(articleRepository.count()).isEqualTo(prevCount + 1);
    }

    @Test
    @DisplayName("update Test")
    void updateTest() {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();

        String updatedHashtag = "#jpa";
        article.setHashtag(updatedHashtag);
        // when
        Article savedArticle = articleRepository.saveAndFlush(article); // 이 내용은 테스트상에선 rollback 되기 때문에, 실제 데이터에 업데이트되는건 아님
        // then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
    }

    @Test
    @DisplayName("delete Test")
    void deleteTest() {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();
        long prevCount = articleRepository.count();
        long prevArticleCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size(); // 지울 댓글 수

        // when
        articleRepository.delete(article);

        // then
        assertThat(articleRepository.count()).isEqualTo(prevCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(prevArticleCommentCount - deletedCommentsSize);
    }

}