package com.pssservice.pssservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="T_SUIVIDESPANNES")
public class SuiviDesPannes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dateDeclaration;
    @Column
    private Date dateDepannage;
    @Column
    private String lieuDuPanne;
    @Column
    private String progression;
    @Column
    private String telClient;
    @Column
    private String telFournisseur;



    @ManyToOne
    private Agent agent;

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
