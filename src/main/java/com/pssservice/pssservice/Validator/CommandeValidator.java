package com.pssservice.pssservice.Validator;

import com.pssservice.pssservice.Dto.CommandeDto;
import org.springframework.util.StringUtils;


import java.util.ArrayList;

import java.util.List;

public class CommandeValidator {

    public static List<String> validate(CommandeDto commandeDto) {
        List<String> errors = new ArrayList<>();
        if (commandeDto == null) {
            errors.add("veuillez renseigner la date du commande");
            errors.add("veuillez renseigner le montant de la commande");
            errors.add("veuillez renseigner le libélé");
            errors.add("veuillez renseigner la quantité");
            errors.add("veuillez renseigner la prix unitaire hors taxe");
            errors.add("veuillez renseigner la TVA");
            errors.add("veuillez renseigner le remise");
        }



        if(!StringUtils.hasLength(commandeDto.getDateCommande().toString())){
            errors.add("veuillez renseigner la date du commande");
        }
        if(!StringUtils.hasLength(commandeDto.getMontant().toString())){
            errors.add("veuillez renseigner le montant de la commande");
        }

        if(!StringUtils.hasLength(commandeDto.getLibele())){
            errors.add("veuillez renseigner le libélé");
        }
        if(!StringUtils.hasLength(commandeDto.getQuantite().toString())){
            errors.add("veuillez renseigner la quantité");
        }
        if(!StringUtils.hasLength(commandeDto.getPrixUnitaireHorsTaxe().toString())){
            errors.add("veuillez renseigner la prix unitaire hors taxe");
        }
        if(!StringUtils.hasLength(commandeDto.getTva().toString())){
            errors.add("veuillez renseigner la TVA");
        }
        if(!StringUtils.hasLength(commandeDto.getRemise().toString())){
            errors.add("veuillez renseigner le remise");
        }
         return errors;
    }
}