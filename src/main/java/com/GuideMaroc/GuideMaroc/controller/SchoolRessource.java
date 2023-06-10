package com.GuideMaroc.GuideMaroc.controller;

import com.GuideMaroc.GuideMaroc.Model.Branch;
import com.GuideMaroc.GuideMaroc.Model.City;
import com.GuideMaroc.GuideMaroc.Model.School;
import com.GuideMaroc.GuideMaroc.Model.Street;
import com.GuideMaroc.GuideMaroc.Service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolRessource {

    private final SchoolService schoolService;

    public SchoolRessource(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<School>> getAllSchools () {
        List<School> schools = schoolService.findAllSchools();
        //System.out.println(schools);
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }
    @GetMapping("/add")
    public ResponseEntity<List<School>> addSchools () {
        School s=new School("COLLÈGE LASALLE2","141, 141 Bis, Bd Mohamed VI, Souissi Rabat"," Ecoles de commerce - Ecoles de gestion - Ecoles de Tourisme - Ecoles Art & Design - Ecoles Informatique & Web - Ecoles d'infographie -","06000000","collegelasalle.ma","private", null,"collegelasalle",new Street(2,"av Mohamed V"));
        schoolService.addShcool(s);
        List<School> employees = schoolService.findAllSchools();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/branches")
    public ResponseEntity<List<Branch>>getAllBranches() {
        List<Branch> branches = schoolService.findAllBranchs();
        //System.out.println(branches);
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
    @GetMapping("/Streets")
    public ResponseEntity<List<Street>>getAllStreets() {
        List<Street> streets = schoolService.findAllStreets();
        //System.out.println(streets);
        return new ResponseEntity<>(streets, HttpStatus.OK);
    }
    @GetMapping("/Cities")
    public ResponseEntity<List<City>>getAllCities() {
        List<City> cities = schoolService.findAllCities();
        //System.out.println(cities);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    @GetMapping("/City/{id}")
    public ResponseEntity<List<School>>getSchoolsInCity(@PathVariable("id") long id_city) {
       City city=schoolService.findCity(id_city);
       List<Street> streetsInCity=city.getStreets();
       List<School> schoolsInCity=schoolService.findSchoolsInCity(streetsInCity);
        //System.out.println(cities);
        System.out.println(schoolsInCity);
        return new ResponseEntity<>(schoolsInCity, HttpStatus.OK);
    }
    @GetMapping("/Branch/{id}")
    public ResponseEntity<List<School>>getSchoolsBranch(@PathVariable("id") long id){
        Branch branch=schoolService.findBranch(id);
        List<School> schoolsBranch=branch.getSchools();
        return new ResponseEntity<>(schoolsBranch, HttpStatus.OK);
    }
}
