package com.pssservice.pssservice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CommandeDto {

    private Long id;
    private Date dateCommande;
    private Double montant;



    private String libele;


    private Double quantite;


    private Double prixUnitaireHorsTaxe;

    private Double Tva;


    private Double remise;





}
