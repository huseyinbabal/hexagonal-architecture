package com.huseyin.hexagonal4j.domain.article.usecase;

public record ArticleQuery(Long accountId) {

    public static ArticleQuery from(Long accountId) {
        return new ArticleQuery(accountId);
    }

}
