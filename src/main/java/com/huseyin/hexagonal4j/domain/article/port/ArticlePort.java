package com.huseyin.hexagonal4j.domain.article.port;

import java.util.List;

import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;

public interface ArticlePort {

    Article create(ArticleCreate articleCreate);

    Article retrieve(Long articleId);

    List<Article> query(ArticleQuery articleQuery);
}
