package com.huseyin.hexagonal4j;

import java.util.List;
import java.util.logging.Logger;

import com.huseyin.hexagonal4j.domain.article.ArticleCreateUseCase;
import com.huseyin.hexagonal4j.domain.article.ArticleQueryUseCase;
import com.huseyin.hexagonal4j.domain.article.ArticleRetrieveUseCase;
import com.huseyin.hexagonal4j.domain.article.model.Article;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleCreate;
import com.huseyin.hexagonal4j.domain.article.usecase.ArticleQuery;
import com.huseyin.hexagonal4j.infrastructure.adapter.article.cli.ArticleCli;
import com.huseyin.hexagonal4j.infrastructure.adapter.article.persistence.ArticleImMemoryDataAdapter;

public class Application {
    static Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

        ArticleImMemoryDataAdapter articleImMemoryDataAdapter = new ArticleImMemoryDataAdapter();

        ArticleCli articleCli = new ArticleCli(
            new ArticleCreateUseCase(articleImMemoryDataAdapter),
            new ArticleRetrieveUseCase(articleImMemoryDataAdapter),
            new ArticleQueryUseCase(articleImMemoryDataAdapter));

        Article article = articleCli.create(new ArticleCreate(5L, "Hexagonal in 5 Minutes",
            "Hexagonal architecture is initially suggested..."));
        log.info("Article is created " + article);

        Article articleDetails = articleCli.retrieve(1L);
        log.info("Article details "+articleDetails);

        List<Article> result = articleCli.query(new ArticleQuery(5L));
        log.info("Found articles " + result);
    }

}
