package com.fanliyan.SpringData.dao;

import com.fanliyan.SpringData.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
