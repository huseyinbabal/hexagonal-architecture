package com.huseyin.hexagonal4j.domain.article.model;

public record Article(
    Long id,
    Long accountId,
    String title,
    String body
) {

}
