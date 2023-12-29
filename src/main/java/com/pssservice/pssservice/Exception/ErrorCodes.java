package com.pssservice.pssservice.Exception;

public enum ErrorCodes {

    AGENT_NOT_FOUND(1000),
    AGENT_INVALID(1001),
    FOURNISSEUR_NOT_FOUND(2000),
    FOURNISSEUR_INVALID(2001),
    ARTICLE_NOT_FOUND(3000),
    ARTICLE_INVALID(3001),
    COMMANDE_NOT_FOUND(4000),
    COMMANDE_INVALID(4001),
    LIGNE_DE_COMMANDE_NOT_FOUND(5000),
    LIGNE_DE_COMMANDE_INVALID(5001),
    SUIVI_DES_PANNES_NOT_FOUND(6000),
    SUIVI_DES_PANNES_INVALID(7001);



    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return  code;
    }
}
