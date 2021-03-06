package com.huseyin.hexagonal4j.infrastructure.adapter.article.persistence;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.port.ArticlePort;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;

public class ArticleImMemoryDataAdapter implements ArticlePort {

    private final ConcurrentHashMap<Long,Article> articles = new ConcurrentHashMap<>();

    @Override
    public Article create(ArticleCreate articleCreate) {
        long id = (articles.size() + 1);
        Article article = new Article(id, articleCreate.accountId(), articleCreate.title(),
            articleCreate.body());
        articles.put(id, article);
        return article;
    }

    @Override
    public Article retrieve(Long articleId) {
        return articles.get(articleId);
    }

    @Override
    public List<Article> query(ArticleQuery articleQuery) {
        return articles.values().stream()
            .filter(a-> a.accountId().equals(articleQuery.accountId()))
            .collect(Collectors.toList());
    }
}
