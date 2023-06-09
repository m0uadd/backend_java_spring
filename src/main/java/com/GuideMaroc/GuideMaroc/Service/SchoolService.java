package com.GuideMaroc.GuideMaroc.Service;

import com.GuideMaroc.GuideMaroc.Model.Branch;
import com.GuideMaroc.GuideMaroc.Model.School;
import com.GuideMaroc.GuideMaroc.repo.BranchRepo;
import com.GuideMaroc.GuideMaroc.repo.SchoolRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SchoolService {
    private final SchoolRepo schoolRepo;
    private final BranchRepo branchRepo;

    @Autowired
    public SchoolService(SchoolRepo schoolRepo, BranchRepo branchRepo) {
        this.schoolRepo = schoolRepo;
       this.branchRepo=branchRepo;
    }
    public List<School> findAllSchools(){
        return schoolRepo.findAll();
    }
    public List<Branch> findAllBranchs(){
        return branchRepo.findAll();
    }
    public void addShcool(School s){
        schoolRepo.save(s);
    }
}
