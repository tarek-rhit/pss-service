package com.pssservice.pssservice.Controller.Api;

import com.pssservice.pssservice.Dto.AgentDto;
import com.pssservice.pssservice.Dto.SuiviDesPannesDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pssservice.pssservice.Utils.Constants.APP_ROOT;

@CrossOrigin(origins="http://localhost:4200")
public interface SuiviDesPannesApi {

    @PostMapping(value = APP_ROOT + "/suivi/creer")
    SuiviDesPannesDto createSuivi(@RequestBody SuiviDesPannesDto suiviDesPannesDto);
    @PutMapping(value = APP_ROOT + "/suivi/modifier")
    SuiviDesPannesDto updateSuivi(@RequestBody SuiviDesPannesDto suiviDesPannesDto);

    @GetMapping(value = APP_ROOT + "/suivi/{sid}")
    SuiviDesPannesDto getSuiviById(@PathVariable Long sid);

    @GetMapping(value = APP_ROOT + "/suivi/all")
    List<SuiviDesPannesDto> getAll();

    @DeleteMapping(value = APP_ROOT + "/suivi/supprimer/{sid}")
    Boolean deleteSuivi( @PathVariable Long sid);

}
