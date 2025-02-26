package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "adresse")
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "RUE")
    private String rue;
    @Column(name = "CODEPOSTAL")
    private String codePostal;
    @Column(name = "VILLE")
    private String ville;

    public Adresse() {
    }

    public Adresse(Integer id, String numero, String rue, String codePostal, String ville) {
        this.id = id;
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
