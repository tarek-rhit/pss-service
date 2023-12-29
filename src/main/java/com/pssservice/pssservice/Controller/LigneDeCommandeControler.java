package com.pssservice.pssservice.Controller;


import com.pssservice.pssservice.Controller.Api.LigneDeCommandeApi;
import com.pssservice.pssservice.Dto.LigneDeCommandeDto;
import com.pssservice.pssservice.Service.LigneDeCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class LigneDeCommandeControler implements LigneDeCommandeApi {

    private LigneDeCommandeService ligneDeCommandeService;

    @Autowired
    public LigneDeCommandeControler(
            LigneDeCommandeService ligneDeCommandeService)
    {
        this.ligneDeCommandeService = ligneDeCommandeService;
    }
    @Override
    public LigneDeCommandeDto createLigneDeCommande(LigneDeCommandeDto ligneDeCommandeDto) {
        return ligneDeCommandeService.createLigneDeCommande(ligneDeCommandeDto);
    }

    @Override
    public LigneDeCommandeDto updateLigneDeCommande(LigneDeCommandeDto ligneDeCommandeDto) {
        return ligneDeCommandeService.updateLigneDeCommande(ligneDeCommandeDto);
    }

    @Override
    public LigneDeCommandeDto getLigneDeCommandeById(Long lid) {
        return ligneDeCommandeService.getLigneDeCommandeByID(lid);
    }

    @Override
    public List<LigneDeCommandeDto> getAll() {
        return ligneDeCommandeService.getAll();
    }

    @Override
    public Boolean deleteLigneDeCommande(Long lid) {
        return ligneDeCommandeService.deleteLigneDeCommande(lid);
    }
}
