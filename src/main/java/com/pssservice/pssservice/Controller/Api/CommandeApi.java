package com.pssservice.pssservice.Controller.Api;


import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Dto.CommandeDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pssservice.pssservice.Utils.Constants.APP_ROOT;

@CrossOrigin(origins="http://localhost:4200")
public interface CommandeApi {

    @PostMapping(value = APP_ROOT + "/commande/creer")
    CommandeDto createCommande(@RequestBody CommandeDto commandeDto);
    @PutMapping(value = APP_ROOT + "/commande/modifier")
    CommandeDto updateCommande(@RequestBody CommandeDto commandeDto);

    @GetMapping(value = APP_ROOT + "/commande/{cid}")
    CommandeDto getCommandeById(@PathVariable Long cid);

    @GetMapping(value = APP_ROOT + "/commande/all")
    List<CommandeDto> getAll();

    @DeleteMapping(value = APP_ROOT + "/commande/supprimer/{cid}")
    Boolean deleteCommande( @PathVariable Long cid);

}
