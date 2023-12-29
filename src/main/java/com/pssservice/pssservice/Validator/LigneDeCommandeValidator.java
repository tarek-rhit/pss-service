package com.pssservice.pssservice.Validator;


import com.pssservice.pssservice.Dto.LigneDeCommandeDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneDeCommandeValidator {
    public  static List<String> validate(LigneDeCommandeDto ligneDeCommandeDto) {
        List<String> errors = new ArrayList<>();
        if (ligneDeCommandeDto == null) {
            errors.add("veuillez renseigner l'id de ligne de commande");

        }
        if (!StringUtils.hasLength(ligneDeCommandeDto.getReference())){
            errors.add("veuillez renseigner l'id de ligne de commande");
        }

        return errors;
    }
}
