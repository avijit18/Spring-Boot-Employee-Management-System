package com.Avijit.EmpManagement.Service;

import java.util.List;

import com.Avijit.EmpManagement.Model.Employee;

public interface empService {
   Employee createEmployee(Employee employee);

   List<Employee> getAllEmployess();

   Employee getEmployeeById(int empid);

  // Employee findEmpByName(String name);

   String DeleteEmployee(int empid);

   String updatEmployee(int empid, Employee emp);

}
