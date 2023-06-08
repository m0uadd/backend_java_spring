package com.GuideMaroc.GuideMaroc.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_branch;
    private String name;
    private String type_formation;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="shcool_branch",
            joinColumns =@JoinColumn(name="school_id"),
            inverseJoinColumns = @JoinColumn(name="branch-id")
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
