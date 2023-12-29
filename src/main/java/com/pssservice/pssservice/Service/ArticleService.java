package com.pssservice.pssservice.Service;

import com.pssservice.pssservice.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);

    ArticleDto updateArticle(ArticleDto articleDto);

    ArticleDto getArticleById(Long aid);

    ArticleDto findArticleByReference(String reference);

    List<ArticleDto> getAll();

    Boolean deleteArticle(Long aid);

}
