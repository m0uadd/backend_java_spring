package com.GuideMaroc.GuideMaroc.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_branch;
    private String name;
    private String type_formation;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="school_branch",
            joinColumns =@JoinColumn(name="branch_id"),
            inverseJoinColumns = @JoinColumn(name="school_id")
    )
    private List<School> schools=new ArrayList<>();

    public Branch(long id_branch, String name, String type_formation, List<School> schools) {
        this.id_branch = id_branch;
        this.name = name;
        this.type_formation = type_formation;
        this.schools = schools;
    }

    public Branch() {
    }

    public long getId_branch() {
        return id_branch;
    }

    public void setId_branch(long id_branch) {
        this.id_branch = id_branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_formation() {
        return type_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id_branch=" + id_branch +
                ", name='" + name + '\'' +
                ", type_formation='" + type_formation + '\'' +
                ", schools=" + schools +
                '}';
    }
}
