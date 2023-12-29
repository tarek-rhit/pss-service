package com.pssservice.pssservice.Validator;

import com.pssservice.pssservice.Dto.SuiviDesPannesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SuiviDesPannesValidator {

    public static List<String> validate(SuiviDesPannesDto suiviDesPannesDto) {
        List<String> errors = new ArrayList<>();

        if (suiviDesPannesDto == null) {
            errors.add("veuillez renseigner la date de declaration");
            errors.add("veuillez renseigner la date de depannage");
            errors.add("veuillez renseigner le lieu du panne");
            errors.add("veuillez renseigner le tel du client");
            errors.add("veuillez renseigner le tel du fournisseur");
            errors.add("veuillez renseigner l'etat du progression");
            return errors;
        }

        if (!StringUtils.hasLength(suiviDesPannesDto.getDateDeclaration().toString())) {
            errors.add("veuillez renseigner la date de declaration");
        }
        if (!StringUtils.hasLength(suiviDesPannesDto.getDateDepannage().toString())) {
            errors.add("veuillez renseigner la date de depannage");
        }
        if (!StringUtils.hasLength(suiviDesPannesDto.getLieuDuPanne())) {
            errors.add("veuillez renseigner le lieu du panne");
        }
        if (!StringUtils.hasLength(suiviDesPannesDto.getTelClient())) {
            errors.add("veuillez renseigner le tel du client");
        }
        if (!StringUtils.hasLength(suiviDesPannesDto.getTelFournisseur())) {
            errors.add("veuillez renseigner le tel du fournisseur");
        }
        if (!StringUtils.hasLength(suiviDesPannesDto.getProgression())) {
            errors.add("veuillez renseigner l'etat du progression");
        }
        return errors;
    }

}
