package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "virement")
public class Virement extends Operation {
    @Column(name = "BENEFICIAIRE")
    private String beneficiaire;

    public Virement() {
    }

    public Virement(Integer id, Double montant, String motif, LocalDateTime date, String beneficiaire) {
        super(id, montant, motif, date);
        this.beneficiaire = beneficiaire;
    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    @Override
    public String toString() {
        return "Virement{" +
                "id=" + getId() +
                ", montant=" + getMontant() +
                ", date=" + getDate() +
                ", motif='" + getMotif() + '\'' +
                ", compte=" + getCompte().getNumero() +
                ", beneficiaire='" + beneficiaire + '\'' +
                '}';
    }

}
