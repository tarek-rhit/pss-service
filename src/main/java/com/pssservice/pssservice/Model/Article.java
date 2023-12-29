package com.pssservice.pssservice.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="T_ARTICLE")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String reference;
    @Column
    private String designation;
    @Column
    private Double prix;
    @Column
    private Double qte;
    @Column
    private String imageArticle;
    @Column
    private String emplacement;


    @ManyToOne
    @JoinTable(name="ARTICLES_FOURNISSEURS",joinColumns = @JoinColumn(name="ARTICLE_ID"),
    inverseJoinColumns = @JoinColumn(name="FOURNISSEUR_ID"))
    private Fournisseur fournisseur;

    @OneToOne
    @JoinColumn(name = "article_ligneDeCommande")
    private LigneDeCommande ligneDeCommande;



    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LigneDeCommande getLigneDeCommande() {
        return ligneDeCommande;
    }

    public void setLigneDeCommande(LigneDeCommande ligneDeCommande) {
        this.ligneDeCommande = ligneDeCommande;
    }
}
