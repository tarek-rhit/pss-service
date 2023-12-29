package com.pssservice.pssservice.Validator;
import com.pssservice.pssservice.Dto.ArticleDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto){

        List<String> errors = new ArrayList<>();
        if (articleDto == null){
            errors.add("veuillez renseigner la reference de l'article");
            errors.add("veuillez renseigner la designiation de l'article");
            errors.add("veuillez renseigner l'image du l'article");
            errors.add("veuillez renseigner le prix de l'article");
            errors.add("veuillez renseigner la quantité de l'article");
            return errors;
        }
        if (!StringUtils.hasLength(articleDto.getReference())){
            errors.add("veuillez renseigner la reference de l'article");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("veuillez renseigner la designiation de l'article");
        }
        if (!StringUtils.hasLength(articleDto.getImageArticle())){
            errors.add("veuillez renseigner l'image du l'article");
        }
        if (articleDto.getPrix() == null){
            errors.add("veuillez renseigner le prix de l'article");
        }
        if (articleDto.getQte() == null){
            errors.add("veuillez renseigner la quantité de l'article");
        }
        return errors;

    }
}
