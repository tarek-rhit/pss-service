package com.pssservice.pssservice.Controller.Api;


import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Dto.LigneDeCommandeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pssservice.pssservice.Utils.Constants.APP_ROOT;

@CrossOrigin(origins="http://localhost:4200")
public interface LigneDeCommandeApi {

    @PostMapping(value = APP_ROOT + "/ligne/creer")
    LigneDeCommandeDto createLigneDeCommande(@RequestBody LigneDeCommandeDto ligneDeCommandeDto);
    @PutMapping(value = APP_ROOT + "/ligne/modifier")
    LigneDeCommandeDto updateLigneDeCommande(@RequestBody LigneDeCommandeDto ligneDeCommandeDto);

    @GetMapping(value = APP_ROOT + "/ligne/{lid}")
    LigneDeCommandeDto getLigneDeCommandeById(@PathVariable Long lid);

    @GetMapping(value = APP_ROOT + "/ligne/all")
    List<LigneDeCommandeDto> getAll();

    @DeleteMapping(value = APP_ROOT + "/ligne/supprimer/{lid}")
    Boolean deleteLigneDeCommande( @PathVariable Long lid);

}
