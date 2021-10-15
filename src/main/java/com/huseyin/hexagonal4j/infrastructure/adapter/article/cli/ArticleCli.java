package com.huseyin.hexagonal4j.infrastructure.adapter.article.cli;

import java.util.List;

import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.port.ArticlePort;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;

public class ArticleCli {
    private final ArticlePort articlePort;

    public ArticleCli(ArticlePort articlePort) {
        this.articlePort = articlePort;
    }

    public Article create(Long accountId,String title,String body){
        ArticleCreate article = ArticleCreate.builder().accountId(accountId).title(title).body(body).build();
        return articlePort.create(article);
    }

    public Article retrieve(Long articleId){
        return articlePort.retrieve(articleId);
    }

    public List<Article> query(Long accountId){
        return articlePort.query(ArticleQuery.from(accountId));
    }
}
