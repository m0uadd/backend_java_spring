package com.GuideMaroc.GuideMaroc.repo;

import com.GuideMaroc.GuideMaroc.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch, Long> {

    Branch findBranchByBranchId(long id);
}
