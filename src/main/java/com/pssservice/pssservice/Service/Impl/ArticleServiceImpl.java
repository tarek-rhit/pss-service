package com.pssservice.pssservice.Service.Impl;
import com.pssservice.pssservice.Dto.ArticleDto;
import com.pssservice.pssservice.Exception.ErrorCodes;
import com.pssservice.pssservice.Exception.InvalidEntityException;
import com.pssservice.pssservice.Model.Article;
import com.pssservice.pssservice.Repository.ArticleRepository;
import com.pssservice.pssservice.Service.ArticleService;
import com.pssservice.pssservice.Validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    public ArticleServiceImpl(
            ArticleRepository articleRepository
    )
    {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article n'est pas valide {}", articleDto);
            throw new InvalidEntityException("Article not valid", ErrorCodes.ARTICLE_INVALID, errors);
        }
        Article article = modelMapper.map(articleDto,Article.class);

        Article created = articleRepository.save(article);

        return modelMapper.map(created,ArticleDto.class);
    }

    @Override
    public ArticleDto updateArticle(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article n'est pas valide {}", articleDto);
            throw new InvalidEntityException("Article not valid", ErrorCodes.ARTICLE_INVALID, errors);
        }
        Article article = modelMapper.map(articleDto,Article.class);

        Article updated = articleRepository.save(article);

        return modelMapper.map(updated,ArticleDto.class);
    }

    @Override
    public ArticleDto getArticleById(Long aid) {
        if(aid == null) {
            log.error("ID de l'article est nul ");
            return null;
        }
        return modelMapper.map(articleRepository.findById(aid),ArticleDto.class);
    }
    @Override
    public ArticleDto findArticleByReference(String reference) {
        if(!StringUtils.hasLength(reference)) {
            log.error("REFERENCE de l'article est nulle ");
            return null;
        }
        return modelMapper.map(articleRepository.findArticleByReference(reference),ArticleDto.class);

    }

    @Override
    public List<ArticleDto> getAll() {
        return articleRepository.findAll().stream()
                .map(a->modelMapper.map(a,ArticleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteArticle(Long aid) {
        if (aid == null) {
            log.error("ID de l'article est nul ");
            return false;
        }
        articleRepository.deleteById(aid);
        return  true;
    }

}
