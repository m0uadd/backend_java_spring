package com.GuideMaroc.GuideMaroc.controller;

import com.GuideMaroc.GuideMaroc.Model.Branch;
import com.GuideMaroc.GuideMaroc.Model.School;
import com.GuideMaroc.GuideMaroc.Model.Street;
import com.GuideMaroc.GuideMaroc.Service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        schoolService.addShcool(new School("ISSI","Rabat agdal","Institut Superieur des Science de l'Ingenieur","06000000","issi.ac.ma","private", null,"issi",new Street(1,"agdal")));
        List<School> employees = schoolService.findAllSchools();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/branches")
    public ResponseEntity<List<Branch>>getAllBranches() {
        List<Branch> branches = schoolService.findAllBranchs();
        //System.out.println(branches);
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }
}
