package com.GuideMaroc.GuideMaroc.Service;

import com.GuideMaroc.GuideMaroc.Model.Branch;
import com.GuideMaroc.GuideMaroc.Model.City;
import com.GuideMaroc.GuideMaroc.Model.School;
import com.GuideMaroc.GuideMaroc.Model.Street;
import com.GuideMaroc.GuideMaroc.repo.BranchRepo;
import com.GuideMaroc.GuideMaroc.repo.CityRepo;
import com.GuideMaroc.GuideMaroc.repo.SchoolRepo;
import com.GuideMaroc.GuideMaroc.repo.StreetRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SchoolService {
    private final SchoolRepo schoolRepo;
    private final BranchRepo branchRepo;
    private final StreetRepo streetRepo;
    private final CityRepo cityRepo;

    @Autowired
    public SchoolService(SchoolRepo schoolRepo, BranchRepo branchRepo,StreetRepo streetRepo,CityRepo cityRepo) {
        this.schoolRepo = schoolRepo;
       this.branchRepo=branchRepo;
       this.streetRepo=streetRepo;
       this.cityRepo=cityRepo;
    }
    public List<School> findAllSchools(){
        return schoolRepo.findAll();
    }
    public List<Branch> findAllBranchs(){
        return branchRepo.findAll();
    }
    public List<Street> findAllStreets(){
        return streetRepo.findAll();
    }
    public List<City> findAllCities(){
        return cityRepo.findAll();
    }
    public City findCity(long id){
        return cityRepo.findCityByCityId(id);
    }
    public void addShcool(School s){
        schoolRepo.save(s);
    }

    public List<School> findSchoolsInCity(List<Street> streetsInCity) {
        return schoolRepo.findByStreetIdIn(streetsInCity);
    }

    public Branch findBranch(long id) {
        return branchRepo.findBranchByBranchId(id);
    }
}
