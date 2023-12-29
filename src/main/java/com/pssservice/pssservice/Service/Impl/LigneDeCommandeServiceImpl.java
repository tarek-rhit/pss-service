package com.pssservice.pssservice.Service.Impl;
import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Dto.LigneDeCommandeDto;
import com.pssservice.pssservice.Exception.ErrorCodes;
import com.pssservice.pssservice.Exception.InvalidEntityException;
import com.pssservice.pssservice.Model.LigneDeCommande;
import com.pssservice.pssservice.Repository.LigneDeCommandeRepository;
import com.pssservice.pssservice.Service.LigneDeCommandeService;
import com.pssservice.pssservice.Validator.LigneDeCommandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LigneDeCommandeServiceImpl implements LigneDeCommandeService {

    @Autowired
    private LigneDeCommandeRepository ligneDeCommandeRepository;

    @Autowired
    private ModelMapper modelMapper ;


    @Autowired
    public LigneDeCommandeServiceImpl(
            LigneDeCommandeRepository ligneDeCommandeRepository,
            ModelMapper modelMapper)
    {
        this.ligneDeCommandeRepository = ligneDeCommandeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LigneDeCommandeDto createLigneDeCommande(LigneDeCommandeDto ligneDeCommandeDto) {
        List<String> errors = LigneDeCommandeValidator.validate(ligneDeCommandeDto);
        if (!errors.isEmpty()){
            log.error("Ligne de commande n'est pas valide {}",ligneDeCommandeDto);
            throw new InvalidEntityException("Ligne de commande  not valid", ErrorCodes.LIGNE_DE_COMMANDE_INVALID,errors);
        }

        LigneDeCommande ligneDeCommande = modelMapper.map(ligneDeCommandeDto,LigneDeCommande.class);
        LigneDeCommande created = ligneDeCommandeRepository.save(ligneDeCommande);
        return  modelMapper.map(created, LigneDeCommandeDto.class);
    }

    @Override
    public LigneDeCommandeDto updateLigneDeCommande(LigneDeCommandeDto ligneDeCommandeDto) {
        List<String> errors = LigneDeCommandeValidator.validate(ligneDeCommandeDto);
        if (!errors.isEmpty()){
            log.error("Ligne de commande n'est pas valide {}",ligneDeCommandeDto);
            throw new InvalidEntityException("Ligne de commande not valid", ErrorCodes.LIGNE_DE_COMMANDE_INVALID,errors);
        }
        LigneDeCommande ligneDeCommande = modelMapper.map(ligneDeCommandeDto,LigneDeCommande.class);
        LigneDeCommande updated=  ligneDeCommandeRepository.save(ligneDeCommande);
        return  modelMapper.map(updated, LigneDeCommandeDto.class);
    }

    @Override
    public LigneDeCommandeDto getLigneDeCommandeByID(Long lid) {
        if (lid == null) {
            log.error("ID de la ligne de commande est nul");
            return null;
        }

        return modelMapper.map(ligneDeCommandeRepository.findById(lid), LigneDeCommandeDto.class);
    }

    @Override
    public List<LigneDeCommandeDto> getAll() {
        return ligneDeCommandeRepository.findAll().stream()
                .map(l->modelMapper.map(l,LigneDeCommandeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteLigneDeCommande(Long lid) {
        if ( lid == null) {
            log.error("ID de la ligne de commande est nul");
            return false;
        }
        ligneDeCommandeRepository.deleteById(lid);
        return true;
    }
}
