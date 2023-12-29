package com.pssservice.pssservice.Service;

import com.pssservice.pssservice.Dto.SuiviDesPannesDto;

import java.util.List;

public interface SuiviDesPannesService {

    SuiviDesPannesDto createSuivi (SuiviDesPannesDto suiviDesPannesDto);

    SuiviDesPannesDto updateSuivi (SuiviDesPannesDto suiviDesPannesDto);

    SuiviDesPannesDto getSuiviById(Long sid);

    List<SuiviDesPannesDto> getAll();

    Boolean deleteSuivi (Long sid);
}
