package com.pssservice.pssservice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentDto {

    private Long id;
    private String prenom;
    private String nom;
    private String patente;

    private String tel;

    private String photo;
    private String address;


    private String email;
    private String metier;




}
