package com.GuideMaroc.GuideMaroc.Model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private long id;
    private String name;
    private String adrress;
    private String info;
    private String phone;
    private String site;
    private String sector;
    @ManyToMany(mappedBy = "schools", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Branch> branches=new ArrayList<>();
    private String ImageUrl;
    @ManyToOne
    @JoinColumn(name = "id_street")
    private Street street_id;

    public School() {
    }

    public School(long id, String name, String adrress, String info, String phone, String site, String sector, List<Branch> branches, String imageUrl, Street street_id) {
        this.id = id;
        this.name = name;
        this.adrress = adrress;
        this.info = info;
        this.phone = phone;
        this.site = site;
        this.sector = sector;
        this.branches = branches;
        ImageUrl = imageUrl;
        this.street_id = street_id;
    }

    public School(String name, String adrress, String info, String phone, String site, String sector, List<Branch> branches, String imageUrl, Street street_id) {
        this.name = name;
        this.adrress = adrress;
        this.info = info;
        this.phone = phone;
        this.site = site;
        this.sector = sector;
        this.branches = branches;
        ImageUrl = imageUrl;
        this.street_id = street_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Street getStreet_id() {
        return street_id;
    }

    public void setStreet_id(Street street_id) {
        this.street_id = street_id;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adrress='" + adrress + '\'' +
                ", info='" + info + '\'' +
                ", phone='" + phone + '\'' +
                ", site='" + site + '\'' +
                ", sector='" + sector + '\'' +
                ", branches=" + branches +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", street_id=" + street_id +
                '}';
    }
}
