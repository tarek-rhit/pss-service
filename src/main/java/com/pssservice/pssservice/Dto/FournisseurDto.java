package com.pssservice.pssservice.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FournisseurDto {


    private Long id;
    private String name;
    private String logo;
    private String address;
    private String email;
    private String matriculeFiscal;
    private String tel;





}
