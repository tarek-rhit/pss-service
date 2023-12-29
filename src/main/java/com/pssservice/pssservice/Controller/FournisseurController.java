package com.pssservice.pssservice.Controller;
import com.pssservice.pssservice.Controller.Api.FournisseurApi;
import com.pssservice.pssservice.Dto.FournisseurDto;
import com.pssservice.pssservice.Service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin (origins="*")
@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;



    @Autowired
    public FournisseurController(
            FournisseurService fournisseurService
    )
    {
        this.fournisseurService = fournisseurService;

    }
    public FournisseurDto createFournisseur(FournisseurDto fournisseurDto) {

        return fournisseurService.createFournisseur(fournisseurDto);
    }

    @Override
    public FournisseurDto updateFournisseur(FournisseurDto fournisseurDto) {
        return fournisseurService.updateFournisseur(fournisseurDto);
    }

    @Override
    public FournisseurDto getFournisseurById(Long fid) {
        return fournisseurService.getFournisseurById(fid);
    }

    @Override
    public List<FournisseurDto> getAll() {
        return fournisseurService.getAll();
    }

    @Override
    public Boolean deleteFournisseur(Long fid) {
        return fournisseurService.deleteFournisseur(fid);
    }

}
