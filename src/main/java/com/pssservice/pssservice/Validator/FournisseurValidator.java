package com.pssservice.pssservice.Validator;

import com.pssservice.pssservice.Dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();
        if (fournisseurDto == null){
            errors.add("veuillez renseigner le nom du fournisseur");
            errors.add("veuillez renseigner l'addresse du fournisseur");
            errors.add("veuillez renseigner l'image du fournisseur");
            errors.add("veuillez renseigner l'email du fournisseur");
            errors.add("veuillez renseigner le numero du telephone du fournisseur");
            errors.add("veuillez renseigner la matricule fiscal du fournisseur");
            return errors;
        }
        if (!StringUtils.hasLength(fournisseurDto.getName())){
            errors.add("veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getAddress())){
            errors.add("veuillez renseigner l'addresse du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getLogo())){
            errors.add("veuillez renseigner l'image du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("veuillez renseigner l'email du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getTel())){
            errors.add("veuillez renseigner le numero du telephone du fournisseur");
        }if (!StringUtils.hasLength(fournisseurDto.getMatriculeFiscal())){
            errors.add("veuillez renseigner la matricule fiscal du fournisseur");
        }
        return errors;
    }
}
