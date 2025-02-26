package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Integer id;
    @Column(name = "MONTANT")
    private Double montant;
    @Column(name = "MOTIF")
    private String motif;
    @Column(name = "DATE")
    private LocalDate date;

    @ManyToMany
    @JoinTable(
            name = "client_compte",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id")
    )
    private Set<Compte> comptes = new HashSet<>();


    public Client() {
    }

    public Client(Integer id, Double montant, String motif, LocalDate date) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public void addCompte(Compte compte) {
        comptes.add(compte);
        compte.getClients().add(this);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", date=" + date +
                '}';
    }
}
