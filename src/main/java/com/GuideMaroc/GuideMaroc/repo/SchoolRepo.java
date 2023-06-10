package com.GuideMaroc.GuideMaroc.repo;

import com.GuideMaroc.GuideMaroc.Model.School;
import com.GuideMaroc.GuideMaroc.Model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepo extends JpaRepository<School, Long> {

    List<School> findByStreetIdIn(List<Street> streetsInCity);
}
