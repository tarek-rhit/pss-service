package com.pssservice.pssservice.Repository;

import com.pssservice.pssservice.Model.SuiviDesPannes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiviDesPannesRepository extends JpaRepository<SuiviDesPannes,Long> {
}
