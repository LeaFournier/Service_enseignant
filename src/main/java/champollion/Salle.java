/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

/**
 *
 * @author leabf
 */
public class Salle {

private String intitule;
private int capacite;

public Salle (String i, int c){
    this.intitule=i;
    this.capacite=c;
}

    public String getIntitule() {
        return intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

}
