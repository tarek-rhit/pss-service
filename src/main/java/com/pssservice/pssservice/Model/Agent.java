package com.pssservice.pssservice.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="T_AGENT")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String prenom;
    @Column
    private String nom;
    @Column
    private String patente;
    @Column
    private String tel;
    @Column
    private String photo;
    @Column
    private String address;

    @Column
    private String email;


    @Column
    private String metier;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "agent_suivis")
    private List<SuiviDesPannes> suivis;


    public List<SuiviDesPannes> getSuivis() {
        return suivis;
    }

    public void setSuivis(List<SuiviDesPannes> suivis) {
        this.suivis = suivis;
    }
}
