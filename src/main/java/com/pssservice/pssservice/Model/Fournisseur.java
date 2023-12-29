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
@Table(name="T_FOURNISSEUR")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String logo;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private String matriculeFiscal;
    @Column
    private String tel;

    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
    private List<Article> articles;

    @OneToMany(mappedBy = "fournisseur")
    private List<Commande> commandes;



    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


}
