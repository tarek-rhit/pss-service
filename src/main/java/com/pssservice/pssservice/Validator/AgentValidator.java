package com.pssservice.pssservice.Validator;

import com.pssservice.pssservice.Dto.AgentDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AgentValidator {

    public static List<String> validate(AgentDto agentDto){
        List<String> errors = new ArrayList<>();

        if (agentDto == null){
            errors.add("veuillez renseigner le prenom de l'agent");
            errors.add("veuillez renseigner le nom de l'agent");
            errors.add("veuillez renseigner l'addresse de l'agent");
            errors.add("veuillez renseigner l'email de l'agent");
            errors.add("veuillez renseigner le numero du telephone de l'agent");
            errors.add("veuillez renseigner l'image de l'agent");
            errors.add("veuillez renseigner le metier de l'agent");
            errors.add("veuillez renseigner la patente de l'agent");
            return errors;
        }
        if (!StringUtils.hasLength(agentDto.getPrenom())){
            errors.add("veuillez renseigner le prenom de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getNom())){
            errors.add("veuillez renseigner le nom de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getPatente())){
            errors.add("veuillez renseigner la patente de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getAddress())){
            errors.add("veuillez renseigner l'adresse de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getTel())){
            errors.add("veuillez renseigner le numero du telephone de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getPhoto())){
            errors.add("veuillez renseigner l'image de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getEmail())){
            errors.add("veuillez renseigner l'email de l'agent");
        }
        if (!StringUtils.hasLength(agentDto.getMetier())){
            errors.add("veuillez renseigner le metier de l'agent");
        }
        return errors;
    }
}
