package com.pssservice.pssservice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuiviDesPannesDto {


    private Long id;
    private Date dateDeclaration;
    private Date dateDepannage;
    private String lieuDuPanne;
    private String progression;
    private String telClient;
    private String telFournisseur;


}
