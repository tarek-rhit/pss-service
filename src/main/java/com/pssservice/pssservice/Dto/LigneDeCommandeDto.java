package com.pssservice.pssservice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneDeCommandeDto {

    private Long id;

    private String reference;

    private String libelé;

    private Double quantité;

    private Double prixUnitaireHorsTaxe;

    private Double TVA;

    private Double remise;
}
