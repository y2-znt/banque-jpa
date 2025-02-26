package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "operation")
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MONTANT")
    private Double montant;
    @Column(name = "MOTIF")
    private String motif;
    @Column(name = "DATE")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    public Operation() {
    }

    public Operation(Integer id, Double montant, String motif, LocalDateTime date) {
        this.id = id;
        this.montant = montant;
        this.motif = motif;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", date=" + date +
                '}';
    }
}
