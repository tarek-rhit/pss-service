package com.pssservice.pssservice.Controller.Api;

import com.pssservice.pssservice.Dto.FournisseurDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pssservice.pssservice.Utils.Constants.APP_ROOT;

@CrossOrigin (origins="http://localhost:4200")
public interface FournisseurApi {


    @PostMapping(value=APP_ROOT+"/fournisseur/creer")
    FournisseurDto createFournisseur(@RequestBody FournisseurDto fournisseurDto);

    @PutMapping(value=APP_ROOT+"/fournisseur/modifier")
    FournisseurDto updateFournisseur(@RequestBody FournisseurDto fournisseurDto);

    @GetMapping(value=APP_ROOT+"/fournisseur/{fid}")
    FournisseurDto getFournisseurById( @PathVariable Long fid);

    @GetMapping(value=APP_ROOT+"/fournisseur/all")
    List<FournisseurDto> getAll();

    @DeleteMapping(value=APP_ROOT+"/fournisseur/supprimer/{fid}")
    Boolean deleteFournisseur( @PathVariable Long fid);
}
