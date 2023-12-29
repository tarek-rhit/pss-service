package com.pssservice.pssservice.Service.Impl;

import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Dto.SuiviDesPannesDto;
import com.pssservice.pssservice.Exception.ErrorCodes;
import com.pssservice.pssservice.Exception.InvalidEntityException;
import com.pssservice.pssservice.Model.Agent;
import com.pssservice.pssservice.Model.SuiviDesPannes;
import com.pssservice.pssservice.Repository.SuiviDesPannesRepository;
import com.pssservice.pssservice.Service.SuiviDesPannesService;

import com.pssservice.pssservice.Validator.AgentValidator;
import com.pssservice.pssservice.Validator.SuiviDesPannesValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SuiviDesPannesImpl implements SuiviDesPannesService{

    private SuiviDesPannesRepository suiviDesPannesRepository;

    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    public SuiviDesPannesImpl(
           SuiviDesPannesRepository suiviDesPannesRepository,
           ModelMapper modelMapper
    ) {
        this.suiviDesPannesRepository = suiviDesPannesRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public SuiviDesPannesDto createSuivi(SuiviDesPannesDto suiviDesPannesDto) {
        List<String> errors = SuiviDesPannesValidator.validate(suiviDesPannesDto);
        if (!errors.isEmpty()){
            log.error("Suivi des pannes n'est pas valide {}",suiviDesPannesDto);
            throw new InvalidEntityException("Suivi des pannes", ErrorCodes.SUIVI_DES_PANNES_INVALID,errors);
        }

        SuiviDesPannes suiviDesPannes = modelMapper.map(suiviDesPannesDto, SuiviDesPannes.class);
        SuiviDesPannes created=  suiviDesPannesRepository.save(suiviDesPannes);
        return  modelMapper.map(created, SuiviDesPannesDto.class);
    }

    @Override
    public SuiviDesPannesDto updateSuivi(SuiviDesPannesDto suiviDesPannesDto) {
        List<String> errors = SuiviDesPannesValidator.validate(suiviDesPannesDto);
        if (!errors.isEmpty()){
            log.error("Suivi des pannes n'est pas valide {}",suiviDesPannesDto);
            throw new InvalidEntityException("Suivi des pannes not valid", ErrorCodes.SUIVI_DES_PANNES_INVALID,errors);
        }
        SuiviDesPannes suiviDesPannes = modelMapper.map(suiviDesPannesDto,SuiviDesPannes.class);
        SuiviDesPannes updated=  suiviDesPannesRepository.save(suiviDesPannes);
        return  modelMapper.map(updated, SuiviDesPannesDto.class);
    }

    @Override
    public SuiviDesPannesDto getSuiviById(Long sid) {
        if (sid == null) {
            log.error("ID du Suivi des pannes est nul");
            return null;
        }

        return modelMapper.map(suiviDesPannesRepository.findById(sid),SuiviDesPannesDto.class);
    }

    @Override
    public List<SuiviDesPannesDto> getAll() {
        return suiviDesPannesRepository.findAll().stream()
                .map(s->modelMapper.map(s,SuiviDesPannesDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteSuivi(Long sid) {
        if ( sid == null) {
            log.error("ID du Suivi des pannes est nul");
            return false;
        }
        suiviDesPannesRepository.deleteById(sid);
        return true;
    }
}
