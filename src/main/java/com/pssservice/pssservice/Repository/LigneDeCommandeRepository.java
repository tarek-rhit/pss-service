package com.pssservice.pssservice.Repository;

import com.pssservice.pssservice.Model.LigneDeCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneDeCommandeRepository extends JpaRepository<LigneDeCommande,Long> {
}
