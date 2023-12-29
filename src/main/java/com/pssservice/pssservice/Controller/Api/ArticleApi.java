package com.pssservice.pssservice.Controller.Api;

import com.pssservice.pssservice.Dto.ArticleDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pssservice.pssservice.Utils.Constants.APP_ROOT;

@CrossOrigin (origins="http://localhost:4200")
public interface ArticleApi {


    @PostMapping(value = APP_ROOT + "/article/creer")
    ArticleDto createArticle(@RequestBody ArticleDto articleDto);

    @PutMapping(value = APP_ROOT + "/article/modifier")
    ArticleDto updateArticle(@RequestBody ArticleDto articleDto);

    @GetMapping(value = APP_ROOT + "/article/{aid}")
    ArticleDto getArticleById(@PathVariable Long aid);

    @GetMapping(value=APP_ROOT+"/article/trouver/{reference}")
    ArticleDto findArticleByReference(@PathVariable String reference);

    @GetMapping(value = APP_ROOT+"/article/all")
    List<ArticleDto> getAll();

    @DeleteMapping(value=APP_ROOT+"/article/supprimer/{aid}")
    Boolean deleteArticle(@PathVariable Long aid);
}
