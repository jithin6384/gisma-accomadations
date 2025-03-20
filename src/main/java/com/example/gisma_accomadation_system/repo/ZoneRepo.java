package com.example.gisma_accomadation_system.repo;

import com.example.gisma_accomadation_system.model.Accommodation;
import com.example.gisma_accomadation_system.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepo extends JpaRepository<Zone, Integer> {


}
