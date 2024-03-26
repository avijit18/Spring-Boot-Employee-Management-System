package com.Avijit.EmpManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Avijit.EmpManagement.Entity.empEntity;
import com.Avijit.EmpManagement.Model.Employee;

@Repository
public interface empRepository extends JpaRepository<empEntity, Integer> {

   
    List<Employee> findEmpByName(String name);
}
