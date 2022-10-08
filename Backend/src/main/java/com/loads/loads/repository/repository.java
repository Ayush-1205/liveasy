package com.loads.loads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loads.loads.model.load;

@Repository
public interface repository extends JpaRepository<load, Long> {

}
