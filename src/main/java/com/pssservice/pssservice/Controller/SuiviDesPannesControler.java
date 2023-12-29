package com.pssservice.pssservice.Controller;


import com.pssservice.pssservice.Controller.Api.SuiviDesPannesApi;
import com.pssservice.pssservice.Dto.SuiviDesPannesDto;
import com.pssservice.pssservice.Service.SuiviDesPannesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
public class SuiviDesPannesControler implements SuiviDesPannesApi {


    private SuiviDesPannesService suiviDesPannesService;

    @Autowired
    public SuiviDesPannesControler(SuiviDesPannesService suiviDesPannesService){
        this.suiviDesPannesService = suiviDesPannesService;
    }

    @Override
    public SuiviDesPannesDto createSuivi(SuiviDesPannesDto suiviDesPannesDto) {
        return suiviDesPannesService.createSuivi(suiviDesPannesDto);
    }

    @Override
    public SuiviDesPannesDto updateSuivi(SuiviDesPannesDto suiviDesPannesDto) {
        return suiviDesPannesService.updateSuivi(suiviDesPannesDto);
    }

    @Override
    public SuiviDesPannesDto getSuiviById(Long sid) {
        return suiviDesPannesService.getSuiviById( sid);
    }

    @Override
    public List<SuiviDesPannesDto> getAll() {
        return suiviDesPannesService.getAll();
    }

    @Override
    public Boolean deleteSuivi(Long sid) {
        return suiviDesPannesService.deleteSuivi(sid);
    }
}
