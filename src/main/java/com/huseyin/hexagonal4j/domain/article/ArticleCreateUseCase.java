package com.huseyin.hexagonal4j.domain.article;

import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.port.ArticlePort;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;

public class ArticleCreateUseCase {

    final ArticlePort articlePort;

    public ArticleCreateUseCase(ArticlePort articlePort) {
        this.articlePort = articlePort;
    }

    Article create(ArticleCreate useCase){
        return this.articlePort.create(useCase);
    }
}
