package com.pssservice.pssservice.Service;

import com.pssservice.pssservice.Dto.CommandeDto;

import java.util.List;

public interface CommandeService {

    CommandeDto createCommande (CommandeDto commandeDto);

    CommandeDto updateCommande(CommandeDto commandeDto);

    CommandeDto getCommandeById(Long cid);

    List<CommandeDto> getAll();

    Boolean deleteCommande( Long cid);
}
