package com.huseyin.hexagonal4j.infrastructure.adapter.article.cli;

import java.util.List;

import com.huseyin.hexagonal4j.domain.article.ArticleCreateUseCase;
import com.huseyin.hexagonal4j.domain.article.ArticleQueryUseCase;
import com.huseyin.hexagonal4j.domain.article.ArticleRetrieveUseCase;
import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.port.ArticlePort;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleRetrieve;

public class ArticleCli implements ArticlePort {
    private  final ArticleCreateUseCase articleCreateUseCase;
    private final ArticleRetrieveUseCase articleRetrieveUseCase;
    private final ArticleQueryUseCase articleQueryUseCase;

    public ArticleCli(ArticleCreateUseCase articleCreateUseCase,
        ArticleRetrieveUseCase articleRetrieveUseCase,
        ArticleQueryUseCase articleQueryUseCase) {
        this.articleCreateUseCase = articleCreateUseCase;
        this.articleRetrieveUseCase = articleRetrieveUseCase;
        this.articleQueryUseCase = articleQueryUseCase;
    }

    @Override
    public Article create(ArticleCreate articleCreate) {
        ArticleCreate article = new ArticleCreate(articleCreate.accountId(),articleCreate.title(),articleCreate.body());
        return this.articleCreateUseCase.create(article);
    }

    @Override
    public Article retrieve(Long articleId){
        return this.articleRetrieveUseCase.retrieve(ArticleRetrieve.from(articleId));
    }

    @Override
    public List<Article> query(ArticleQuery articleQuery) {
        return this.articleQueryUseCase.query(ArticleQuery.from(articleQuery.accountId()));
    }
}
