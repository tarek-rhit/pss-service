package com.pssservice.pssservice.Service;

import com.pssservice.pssservice.Dto.LigneDeCommandeDto;

import java.util.List;

public interface LigneDeCommandeService {

    LigneDeCommandeDto createLigneDeCommande (LigneDeCommandeDto ligneDeCommandeDto);

    LigneDeCommandeDto updateLigneDeCommande (LigneDeCommandeDto ligneDeCommandeDto);

    LigneDeCommandeDto getLigneDeCommandeByID (Long lid);

    List<LigneDeCommandeDto> getAll();

    Boolean deleteLigneDeCommande( Long lid);

}
