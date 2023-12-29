package com.pssservice.pssservice.Controller;


import com.pssservice.pssservice.Controller.Api.CommandeApi;
import com.pssservice.pssservice.Dto.CommandeDto;
import com.pssservice.pssservice.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class CommandeControler implements CommandeApi {

    private CommandeService commandeService;

    @Autowired
    public CommandeControler(
            CommandeService commandeService
    )
    {
        this.commandeService = commandeService;
    }
    @Override
    public CommandeDto createCommande(CommandeDto commandeDto) {
        return commandeService.createCommande(commandeDto);
    }

    @Override
    public CommandeDto updateCommande(CommandeDto commandeDto) {
        return commandeService.updateCommande(commandeDto);
    }

    @Override
    public CommandeDto getCommandeById(Long cid) {
        return commandeService.getCommandeById(cid);
    }

    @Override
    public List<CommandeDto> getAll() {
        return commandeService.getAll();
    }

    @Override
    public Boolean deleteCommande(Long cid) {
        return commandeService.deleteCommande(cid);
    }
}
