package com.Avijit.EmpManagement.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Avijit.EmpManagement.Model.Employee;
import com.Avijit.EmpManagement.Service.empServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/employess")
public class EmpController {

    @Autowired
    empServiceImpl empService;

    @GetMapping()
    public List<Employee> getAllEmployess() {
        return empService.getAllEmployess();
    }

    @GetMapping("/{id}")
    public Employee getEmpByID(@PathVariable int id) {
        return empService.getEmployeeById(id);
    }

    // @GetMapping("/name/{name}")
    // public Employee getEmpByName(@PathVariable String name) {
    //     return empService.findEmpByName(name);
    // }

    @PostMapping()
    public String createNewEmployee(@RequestBody Employee emp) {
        empService.createEmployee(emp);
        return "Saved Successfully";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        return empService.updatEmployee(id, emp);

    }

    @DeleteMapping("/{id}")
    public String deleteEmpbyID(@PathVariable int id) {
        return empService.DeleteEmployee(id);
    }
}
