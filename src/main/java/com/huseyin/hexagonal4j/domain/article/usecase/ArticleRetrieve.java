package com.huseyin.hexagonal4j.domain.article.usecase;

public record ArticleRetrieve(Long id) {

    public static ArticleRetrieve from(Long id) {
        return new ArticleRetrieve(id);
    }

}
