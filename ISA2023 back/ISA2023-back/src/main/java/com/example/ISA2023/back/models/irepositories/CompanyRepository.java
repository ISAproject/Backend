package com.example.ISA2023.back.models.irepositories;

import com.example.ISA2023.back.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long > {
    @Query("SELECT c FROM Company c WHERE LOWER(c.name) LIKE LOWER('%' || ?1 || '%') OR LOWER(c.address) LIKE LOWER('%' || ?1 || '%') AND c.avgGrade>=?2")
    List<Company> findByAddressNameRating(String content,double rating);

    @Query("SELECT c FROM Company c WHERE c.avgGrade>=?1")
    List<Company> findByRating(double rating);

}
