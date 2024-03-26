package com.Avijit.EmpManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Avijit.EmpManagement.Entity.empEntity;
import com.Avijit.EmpManagement.Model.Employee;
import com.Avijit.EmpManagement.Repository.empRepository;

@Service
public class empServiceImpl implements empService {

    @Autowired
    empRepository empRepository;

    @SuppressWarnings("null")
    @Override
    public Employee createEmployee(Employee employee) {
        empEntity empEntity = new empEntity();
        BeanUtils.copyProperties(employee, empEntity);
        empRepository.save(empEntity);
        // employess.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployess() {
        List<empEntity> employeeList = empRepository.findAll();
        List<Employee> employess = new ArrayList<>();
        for (empEntity empEntity : employeeList) {
            Employee emp = new Employee();
            emp.setId(empEntity.getId());
            emp.setName(empEntity.getName());
            emp.setEmail(empEntity.getEmail());
            emp.setPhoNum(empEntity.getPhoNum());
            emp.setCompanyName(empEntity.getCompanyName());
            employess.add(emp);
        }
        return employess;
    }

    @SuppressWarnings("null")
    @Override
    public Employee getEmployeeById(int empid) {
        empEntity emp = empRepository.findById(empid).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp, employee);
        return employee;
    }

    
    // @Override
    // public Employee findEmpByName(String name) {
    //     return empRepository.findEmpByName(name);
    // }

    @SuppressWarnings("null")
    @Override
    public String DeleteEmployee(int empid) {
        // if (employess.remove(empid) != null)
        // return "Deleted Successfully";
        // return "User Not found";
        empEntity empEntity = empRepository.findById(empid).get();
        empRepository.delete(empEntity);
        return "Deleted Successfully";
    }

    @Override
    public String updatEmployee(int empid, Employee emp) {
        // Employee existingEmp = employess.get(empid);
        // if (existingEmp != null)
        // existingEmp.setName(emp.getName());
        // existingEmp.setPhoNum(emp.getPhoNum());
        // existingEmp.setEmail(emp.getEmail());
        // existingEmp.setCompanyName(emp.getCompanyName());

        empEntity existingEmp = empRepository.findById(empid).get();
        existingEmp.setName(emp.getName());
        existingEmp.setPhoNum(emp.getPhoNum());
        existingEmp.setEmail(emp.getEmail());
        existingEmp.setCompanyName(emp.getCompanyName());

        empRepository.save(existingEmp);

        return "Updated Successfully";

    }

}
