package com.pssservice.pssservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="T_COMMANDE")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dateCommande;



    @Column
    private String libele;

    @Column
    private Double quantite;

    @Column
    private Double prixUnitaireHorsTaxe;

    @Column
    private Double Tva;

    @Column
    private Double remise;
    @Column
    private Double montant;

    @OneToMany(mappedBy = "commande")
    private List<LigneDeCommande> lignes;

    @ManyToOne
    @JoinColumn(name = "user_commandes")
    private Fournisseur fournisseur;


    public List<LigneDeCommande> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneDeCommande> lignes) {
        this.lignes = lignes;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
}
