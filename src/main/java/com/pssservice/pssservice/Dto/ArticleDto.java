package com.pssservice.pssservice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Long id;
    private String reference;

    private String designation;

    private Double prix;
    private Double qte;

    private String imageArticle;





}
