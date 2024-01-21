package com.fastcampus.fastcampusprojectboard.repository;

import com.fastcampus.fastcampusprojectboard.domain.Article;
import com.fastcampus.fastcampusprojectboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>, // Article 엔티티 안에 있는 모든 필드에 대한 검색 기능 추가
        QuerydslBinderCustomizer<QArticle> {
    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true); // 검색 대상에서 제외
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy); // 검색 대상에 포함
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase); // 제목에 대한 검색
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase); // 제목에 대한 검색
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // 제목에 대한 검색
        bindings.bind(root.createdAt).first(DateTimeExpression::eq); // 제목에 대한 검색
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase); // 제목에 대한 검색

    }
}