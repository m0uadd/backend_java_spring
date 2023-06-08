package com.GuideMaroc.GuideMaroc.Model;


import jakarta.persistence.*;


import java.io.Serializable;

@Entity
public class Street implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_street;
    private String nom;

    public Street() {
    }

    public Street(long id_street, String nom) {
        this.id_street = id_street;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id_street=" + id_street +
                ", nom='" + nom + '\'' +
                '}';
    }
}
