package com.pssservice.pssservice.Service;

import com.pssservice.pssservice.Dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto createFournisseur( FournisseurDto fournisseurDto);

    FournisseurDto updateFournisseur(FournisseurDto fournisseurDto);

    FournisseurDto getFournisseurById( Long fid);

    List<FournisseurDto> getAll();

    Boolean deleteFournisseur( Long fid);
}
