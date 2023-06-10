package com.GuideMaroc.GuideMaroc.repo;

import com.GuideMaroc.GuideMaroc.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City,Long> {
    public City findCityByCityId(long City_id);
}
