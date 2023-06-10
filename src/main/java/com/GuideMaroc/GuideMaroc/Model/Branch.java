package com.GuideMaroc.GuideMaroc.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "branchId")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String name;
    private String type_formation;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="school_branch",
            joinColumns =@JoinColumn(name="branch_id"),
            inverseJoinColumns = @JoinColumn(name="school_id")
    )
    @JsonIgnore
    private List<School> schools=new ArrayList<>();

    public Branch(long branchId, String name, String type_formation, List<School> schools) {
        this.branchId = branchId;
        this.name = name;
        this.type_formation = type_formation;
        this.schools = schools;
    }

    public Branch() {
    }

    public long getbranchId() {
        return branchId;
    }

    public void setbranchId(long branchId) {
        this.branchId = branchId;
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
                "branchId=" + branchId +
                ", name='" + name + '\'' +
                ", type_formation='" + type_formation + '\'' +
                ", schools=" + schools +
                '}';
    }
}
