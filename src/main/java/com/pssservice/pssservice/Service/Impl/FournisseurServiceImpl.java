package com.pssservice.pssservice.Service.Impl;
import com.pssservice.pssservice.Dto.FournisseurDto;
import com.pssservice.pssservice.Exception.ErrorCodes;
import com.pssservice.pssservice.Exception.InvalidEntityException;

import com.pssservice.pssservice.Model.Fournisseur;
import com.pssservice.pssservice.Repository.FournisseurRepository;
import com.pssservice.pssservice.Service.FournisseurService;
import com.pssservice.pssservice.Validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private ModelMapper modelMapper ;


    @Autowired
    public FournisseurServiceImpl(
            FournisseurRepository fournisseurRepository

    )
    {
        this.fournisseurRepository = fournisseurRepository;

    }


    @Override
    public FournisseurDto createFournisseur(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if (!errors.isEmpty()){
            log.error("Fournisseur n'est pas valide {}",fournisseurDto);
            throw new InvalidEntityException("Fournisseur not valid", ErrorCodes.FOURNISSEUR_INVALID,errors);
        }

        Fournisseur fournisseur = modelMapper.map(fournisseurDto,Fournisseur.class);
          Fournisseur created=  fournisseurRepository.save(fournisseur);
          return  modelMapper.map(created,FournisseurDto.class);
    }

    @Override
    public FournisseurDto updateFournisseur(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if (!errors.isEmpty()){
            log.error("Fournisseur n'est pas valide {}",fournisseurDto);
            throw new InvalidEntityException("Fournisseur not valid", ErrorCodes.FOURNISSEUR_INVALID,errors);
        }
        Fournisseur fournisseur = modelMapper.map(fournisseurDto,Fournisseur.class);
        Fournisseur updated=  fournisseurRepository.save(fournisseur);
        return  modelMapper.map(updated,FournisseurDto.class);
    }

    @Override
    public FournisseurDto getFournisseurById(Long fid) {
        if (fid == null) {
            log.error("ID du fournisseur est nul");
            return null;
        }

        return  modelMapper.map((fournisseurRepository.findById(fid)),FournisseurDto.class);
    }

    @Override
    public List<FournisseurDto> getAll() {
        return fournisseurRepository.findAll().stream()
                .map(f->modelMapper.map(f,FournisseurDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteFournisseur(Long fid) {
        if (fid == null) {
            log.error("ID du fournisseur est nul");
            return false;
        }
        fournisseurRepository.deleteById(fid);
        return  true;
    }

}
