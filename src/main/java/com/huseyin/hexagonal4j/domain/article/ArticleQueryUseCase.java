package com.huseyin.hexagonal4j.domain.article;

import java.util.List;

import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.port.ArticlePort;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;

public class ArticleQueryUseCase {

    final ArticlePort articlePort;

    public ArticleQueryUseCase(ArticlePort articlePort) {
        this.articlePort = articlePort;
    }

    public List<Article> query(ArticleQuery useCase){
        return articlePort.query(useCase);
    }
}
