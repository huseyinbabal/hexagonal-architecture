package com.huseyin.hexagonal4j.infrastructure.adapter.article.cli;

import java.util.List;

import com.huseyin.hexagonal4j.domain.article.ArticleCreateUseCase;
import com.huseyin.hexagonal4j.domain.article.ArticleQueryUseCase;
import com.huseyin.hexagonal4j.domain.article.ArticleRetrieveUseCase;
import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleRetrieve;

public class ArticleCli {
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

    public Article create(Long accountId,String title,String body){
        ArticleCreate article = new ArticleCreate(accountId,title,body);
        return this.articleCreateUseCase.create(article);
    }

    public Article retrieve(Long articleId){
        return this.articleRetrieveUseCase.retrieve(ArticleRetrieve.from(articleId));
    }

    public List<Article> query(Long accountId){
        return this.articleQueryUseCase.query(ArticleQuery.from(accountId));
    }
}
