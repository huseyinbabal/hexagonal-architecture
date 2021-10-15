package com.huseyin.hexagonal4j.domain.article;

import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.port.ArticlePort;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleRetrieve;

public class ArticleRetrieveUseCase {

    final ArticlePort articlePort;

    public ArticleRetrieveUseCase(ArticlePort articlePort) {
        this.articlePort = articlePort;
    }

    Article retrieve(ArticleRetrieve useCase){
        return this.articlePort.retrieve(useCase.getId());
    }
}
