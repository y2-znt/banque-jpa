package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "livretA")
public class LivretA extends Compte {
    @Column(name = "TAUX")
    private Double taux;

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                ", taux=" + taux +
                '}';
    }
}
