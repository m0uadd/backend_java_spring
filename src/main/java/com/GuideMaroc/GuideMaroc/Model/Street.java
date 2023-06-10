package com.GuideMaroc.GuideMaroc.Model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_street")
public class Street implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_street;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_city")
    @JsonIgnore
    private City city;

    public Street() {
    }

    public Street(long id_street, String nom) {
        this.id_street = id_street;
        this.nom = nom;
    }

    public long getId_street() {
        return id_street;
    }

    public void setId_street(long id_street) {
        this.id_street = id_street;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Street{" +
                "id_street=" + id_street +
                ", nom='" + nom + '\'' +
                ", city=" + city +
                '}';
    }
}
