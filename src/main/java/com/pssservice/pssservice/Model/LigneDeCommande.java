package com.pssservice.pssservice.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="T_LIGNEDECOMMANDE")
public class LigneDeCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne
    @JoinTable(name="COMMANDE_LIGNEDECOMMANDE",joinColumns = @JoinColumn(name="IDLIGNEDECOMMANDE"),
            inverseJoinColumns = @JoinColumn(name="COMMANDE_ID"))
    private Commande commande;

    @OneToOne(mappedBy = "ligneDeCommande",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Article article;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
