package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assuranceVie")
public class AssuranceVie extends Compte {
    @Column(name = "DATEFIN")
    private LocalDate dateFin;
    @Column(name = "TAUX")
    private Double taux;

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "id=" + getId() +
                ", numero='" + getNumero() + '\'' +
                ", solde=" + getSolde() +
                ", dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}
