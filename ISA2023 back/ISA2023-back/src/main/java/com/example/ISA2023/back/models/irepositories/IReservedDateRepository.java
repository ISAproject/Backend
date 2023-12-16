package com.example.ISA2023.back.models.irepositories;

import com.example.ISA2023.back.models.ReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservedDateRepository extends JpaRepository<ReservedDate, Long > {
    @Query("SELECT r FROM ReservedDate r WHERE r.CompanyId = ?1")
    public List<ReservedDate> GetByCompany(long companyId);

}
