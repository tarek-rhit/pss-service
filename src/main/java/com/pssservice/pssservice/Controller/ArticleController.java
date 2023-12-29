package com.pssservice.pssservice.Controller;
import com.pssservice.pssservice.Controller.Api.ArticleApi;
import com.pssservice.pssservice.Dto.ArticleDto;
import com.pssservice.pssservice.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin (origins="*")
@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        return articleService.createArticle(articleDto);
    }

    @Override
    public ArticleDto updateArticle(ArticleDto articleDto) {
        return articleService.updateArticle(articleDto);
    }

    @Override
    public ArticleDto getArticleById(Long aid) {
        return articleService.getArticleById(aid);
    }


    @Override
    public ArticleDto findArticleByReference(String reference) {
        return articleService.findArticleByReference(reference);
    }



    @Override
    public List<ArticleDto> getAll() {
        return articleService.getAll();
    }

    @Override
    public Boolean deleteArticle(Long aid) {
        return articleService.deleteArticle(aid);
    }

}

