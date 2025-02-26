package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "courant")
public class Courant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DECOUVERT")
    private Double decouvert;

    public Courant() {
    }

    public Courant(Integer id, Double decouvert) {
        this.id = id;
        this.decouvert = decouvert;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return "Courant{" +
                "id=" + id +
                ", decouvert=" + decouvert +
                '}';
    }
}
