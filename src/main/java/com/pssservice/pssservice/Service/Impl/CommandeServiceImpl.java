package com.pssservice.pssservice.Service.Impl;

import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Dto.CommandeDto;
import com.pssservice.pssservice.Exception.ErrorCodes;
import com.pssservice.pssservice.Exception.InvalidEntityException;
import com.pssservice.pssservice.Model.Agent;
import com.pssservice.pssservice.Model.Commande;
import com.pssservice.pssservice.Repository.CommandeRepository;
import com.pssservice.pssservice.Service.CommandeService;
import com.pssservice.pssservice.Validator.AgentValidator;
import com.pssservice.pssservice.Validator.CommandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    public CommandeServiceImpl(CommandeRepository commandeRepository){
        this.commandeRepository=commandeRepository;
    }

    @Override
    public CommandeDto createCommande(CommandeDto commandeDto) {
        List<String> errors = CommandeValidator.validate(commandeDto);
        if(!errors.isEmpty()){
            log.error("Commande n'est pas valide{}",commandeDto);
            throw new InvalidEntityException("Commande not valide", ErrorCodes.COMMANDE_INVALID,errors);
        }
        System.out.println(commandeDto.getDateCommande());
        Commande commande = modelMapper.map(commandeDto,Commande.class);
        Commande created=  commandeRepository.save(commande);
        return  modelMapper.map(created, CommandeDto.class);
    }

    @Override
    public CommandeDto updateCommande(CommandeDto commandeDto) {
        List<String> errors = CommandeValidator.validate(commandeDto);
        if (!errors.isEmpty()){
            log.error("Commande n'est pas valide {}",commandeDto);
            throw new InvalidEntityException("Commande not valid", ErrorCodes.COMMANDE_INVALID,errors);
        }
        Commande commande = modelMapper.map(commandeDto,Commande.class);
        Commande updated=  commandeRepository.save(commande);
        return  modelMapper.map(updated, CommandeDto.class);
    }

    @Override
    public CommandeDto getCommandeById(Long cid) {
        if (cid == null) {
            log.error("ID de la commande est nul");
            return null;
        }

        return modelMapper.map(commandeRepository.findById(cid),CommandeDto.class);
    }

    @Override
    public List<CommandeDto> getAll() {
        return commandeRepository.findAll().stream()
                .map(c->modelMapper.map(c,CommandeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteCommande(Long cid) {
        if ( cid == null) {
            log.error("ID de la commande est nul");
            return false;
        }
        commandeRepository.deleteById(cid);
        return true;
    }

}
